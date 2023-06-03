;;; Sierra Script 1.0 - (do not remove this comment)
(script# 978)
(include sci.sh)
(use Main)
(use Print)
(use IconI)


(class GameControls of IconBar
	(properties
		elements 0
		size 0
		height 200
		underBits 0
		oldMouseX 0
		oldMouseY 0
		curIcon 0
		highlightedIcon 0
		prevIcon 0
		curInvIcon 0
		useIconItem 0
		helpIconItem 0
		walkIconItem 0
		port 0
		window 0
		state $0000
		activateHeight 0
		y 0
		okButton 0
	)
	
	(method (show &tmp temp0 temp1 temp2 temp3 temp4 [temp5 10])
		(gSounds pause:)
		(if
		(and gPseudoMouse (gPseudoMouse respondsTo: #stop))
			(gPseudoMouse stop:)
		)
		(= state (| state $0020))
		(if (IsObject window)
			(window open:)
		else
			(= window
				((gEcoWin new:)
					top: 46
					left: 24
					bottom: 155
					right: 296
					priority: 15
					open:
					yourself:
				)
			)
		)
		(= temp0 30)
		(= temp1 30)
		(= temp2 (FirstNode elements))
		(while temp2
			(= temp3 (NextNode temp2))
			(if (not (IsObject (= temp4 (NodeValue temp2))))
				(return)
			)
			(if
				(and
					(not (& (temp4 signal?) $0080))
					(<= (temp4 nsRight?) 0)
				)
				(temp4 show: temp0 temp1)
				(= temp0 (+ 20 (temp4 nsRight?)))
			else
				(temp4 show:)
			)
			(= temp2 temp3)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(if curIcon
			(gGame
				setCursor:
					gCursorNumber
					1
					(+
						(curIcon nsLeft?)
						(/ (- (curIcon nsRight?) (curIcon nsLeft?)) 2)
					)
					(- (curIcon nsBottom?) 3)
			)
		)
		(self doit: hide:)
	)
	
	(method (hide)
		(if window (window dispose:) (= window 0))
		(if (& state $0020)
			(gSounds pause: 0)
			(= state (& state $ffdf))
		)
	)
	
	(method (select param1 param2)
		(param1 select: (if (>= argc 2) param2 else 0))
	)
	
	(method (swapCurIcon)
	)
	
	(method (advanceCurIcon &tmp temp0)
	)
	
	(method (dispatchEvent pEvent &tmp gEcoWinEraseOnly temp1 temp2 [temp3 50] pEventType pEventMessage)
		(= pEventType (pEvent type?))
		(= pEventMessage (pEvent message?))
		(return
			(cond 
				((== pEventType evHELP)
					(if
						(and
							(= temp1 (self firstTrue: #onMe pEvent))
							(temp1 helpVerb?)
						)
						(= temp2 (GetPort))
						(if (gEcoWin respondsTo: #eraseOnly)
							(= gEcoWinEraseOnly (gEcoWin eraseOnly?))
							(gEcoWin eraseOnly: 1)
							(if (& global90 $0002)
								(DoAudio
									2
									(temp1 modNum?)
									(temp1 noun?)
									(temp1 helpVerb?)
									0
									1
								)
							)
							(if (& global90 $0001)
								(Print
									font: gFont
									width: 250
									addText: (temp1 noun?) (temp1 helpVerb?) 0 1 0 0 (temp1 modNum?)
									init:
								)
							)
							(gEcoWin eraseOnly: gEcoWinEraseOnly)
						else
							(if (& global90 $0002)
								(DoAudio
									2
									(temp1 modNum?)
									(temp1 noun?)
									(temp1 helpVerb?)
									0
									1
								)
							)
							(if (& global90 $0001)
								(Print
									font: gFont
									width: 250
									addText: (temp1 noun?) (temp1 helpVerb?) 0 1 0 0 (temp1 modNum?)
									init:
								)
							)
						)
						(SetPort temp2)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal?) $ffef))
					)
					(gGame setCursor: 999)
					(return 0)
				)
				((& pEventType evJOYSTICK)
					(switch pEventMessage
						(JOY_DOWN
							(cond 
								(
									(and
										(IsObject highlightedIcon)
										(highlightedIcon respondsTo: #retreat)
									)
									(highlightedIcon retreat:)
									(return 0)
								)
								(
									(or
										(not (IsObject highlightedIcon))
										(& (highlightedIcon signal?) $0100)
									)
									(self advance:)
									(return 0)
								)
							)
						)
						(JOY_UP
							(cond 
								(
									(and
										(IsObject highlightedIcon)
										(highlightedIcon respondsTo: #advance)
									)
									(highlightedIcon advance:)
									(return 0)
								)
								(
									(or
										(not (IsObject highlightedIcon))
										(& (highlightedIcon signal?) $0100)
									)
									(self retreat:)
									(return 0)
								)
							)
						)
						(else 
							(super dispatchEvent: pEvent)
						)
					)
				)
				(else (super dispatchEvent: pEvent))
			)
		)
	)
)

(class ControlIcon of IconI
	(properties
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state $0000
		cursor -1
		type $4000
		message -1
		modifiers $0000
		signal $0001
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
		theObj 0
		selector 0
	)
	
	(method (doit)
		(if theObj
			(if (& signal $0040)
				((if gGameControls else GameControls) hide:)
			)
			(gGame panelObj: theObj panelSelector: selector)
		)
	)
)
