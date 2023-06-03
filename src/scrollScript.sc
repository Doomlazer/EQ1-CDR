;;; Sierra Script 1.0 - (do not remove this comment)
(script# 816)
(include sci.sh)
(use Main)
(use EcoFeature)
(use RTRandCycle)
(use User)
(use Obj)

(public
	scrollScript 0
)

(local
	local0
	userControls
	theGPicNumber =  -1
	theGPseudoMouse
	pEventX
	pEventY
	[local6 7]
)
(procedure (localproc_0046 param1 param2 &tmp temp0 temp1)
	(while
		(and
			(= temp0 (FirstNode (param1 elements?)))
			(IsObject (= temp1 (NodeValue temp0)))
		)
		(param2 add: temp1)
		(param1 delete: temp1)
	)
)

(procedure (localproc_007c)
	(if (> (ProphesyScroll y?) 132)
		(ProphesyScroll y: (- (ProphesyScroll y?) 4) forceUpd:)
		(upperRoll cel: (not (upperRoll cel?)) forceUpd:)
		(lowerRoll cel: (not (lowerRoll cel?)) forceUpd:)
		(= gProphesyScrollY (ProphesyScroll y?))
	)
)

(procedure (localproc_00d7)
	(if (< (ProphesyScroll y?) 230)
		(ProphesyScroll y: (+ (ProphesyScroll y?) 4) forceUpd:)
		(upperRoll cel: (not (upperRoll cel?)) forceUpd:)
		(lowerRoll cel: (not (lowerRoll cel?)) forceUpd:)
		(= gProphesyScrollY (ProphesyScroll y?))
	)
)

(procedure (localproc_0132 &tmp temp0)
	(= temp0 (- (ProphesyScroll y?) pEventY))
	(= pEventX (- pEventX (ProphesyScroll nsLeft?)))
	(return
		(cond 
			((< temp0 12) 10)
			((< temp0 31) (if (< pEventX 51) 7 else 8))
			((< temp0 59) (cond 
				((< pEventX 43) 5)
				((< temp0 45) 6)
				(else 9)
			))
			((< temp0 97) 4)
			((< temp0 125) 3)
			((< temp0 165) 2)
			(else 1)
		)
	)
)

(instance scrollScript of Script
	(properties)
	
	(method (init)
		(= global250 1)
		(super init: &rest)
		(gEcoDirectionHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (doit)
		(super doit:)
		(if (GameIsRestarting)
			(= start (= start 2))
			(= gPseudoMouse theGPseudoMouse)
			(= theGPseudoMouse 0)
			(self init:)
		)
	)
	
	(method (dispose &tmp temp0)
		(proc0_1)
		(gFeatures release:)
		(global2 drawPic: register 10)
		(if (!= (= gPicNumber theGPicNumber) -1)
			(DrawPic gPicNumber dpOPEN_FADEPALETTE dpNO_CLEAR)
		)
		(localproc_0046 aList gAddToPics)
		(localproc_0046 fList gFeatures)
		(localproc_0046 cList gCast)
		(gAddToPics doit:)
		(aList
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(fList eachElementDo: #perform fdc release: dispose:)
		(cList
			eachElementDo: #dispose
			eachElementDo: #delete
			dispose:
		)
		(gGame setCursor: ((gIconBar curIcon?) cursor?))
		(global2 lookStr: local0)
		(ProphesyScroll dispose: delete:)
		(upperRoll dispose: delete:)
		(lowerRoll dispose: delete:)
		(gEcoDirectionHandler delete: self)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
		(proc0_2)
		(User canControl: userControls)
		(gIconBar enable: 7)
		(= temp0 0)
		(while (< temp0 6)
			(if (!= [local6 temp0] 0)
				(gIconBar disable: (gIconBar at: temp0))
			)
			(++ temp0)
		)
		(if (== gNumber 540)
			(if (> global102 16)
				(Animate (gCast elements?) 0)
			else
				(global2 drawPic: 901)
			)
			(global2 notify: 1)
		)
		(= gPseudoMouse theGPseudoMouse)
		(= theGPseudoMouse 0)
		(DisposeScript 816)
	)
	
	(method (changeState newState &tmp temp0 [temp1 20] [temp21 20])
		(switch (= state (= state newState))
			(0
				(= temp0 0)
				(while (< temp0 6)
					(= [local6 temp0]
						(& ((gIconBar at: temp0) signal?) $0004)
					)
					(++ temp0)
				)
				(gEgo setMotion: 0)
				(= userControls (User controls?))
				(= theGPseudoMouse gPseudoMouse)
				(= gPseudoMouse 0)
				(User canControl: 0)
				(gIconBar disable: 0 7)
				(= local0 (global2 lookStr?))
				(global2 lookStr: 0)
				(= cycles (= cycles 2))
			)
			(1
				(= register (= register (global2 curPic?)))
				(= theGPicNumber gPicNumber)
				(localproc_0046 gAddToPics aList)
				(localproc_0046 gFeatures fList)
				(localproc_0046 gCast cList)
				(global2 drawPic: 901 10)
				(gIconBar curIcon: (gIconBar at: 1))
				(proc0_2)
				(gIconBar disable: 5 0 3 4 5 6)
				(= cycles (= cycles 2))
			)
			(2
				(if (HaveMouse)
					(Message msgGET 5 3 0 0 21 @temp1)
					(Message msgGET 5 3 0 0 22 @temp21)
					(Display
						@temp1
						dsCOORD
						70
						159
						dsCOLOR
						global213
						dsFONT
						300
					)
					(Display
						@temp21
						dsCOORD
						69
						170
						dsCOLOR
						global213
						dsFONT
						300
					)
				else
					(Message msgGET 5 3 0 0 23 @temp1)
					(Message msgGET 5 3 0 0 24 @temp21)
					(Display
						@temp1
						dsCOORD
						49
						159
						dsCOLOR
						global213
						dsFONT
						300
					)
					(Display
						@temp21
						dsCOORD
						86
						170
						dsCOLOR
						global213
						dsFONT
						300
					)
				)
				(ProphesyScroll init:)
				(upperRoll init:)
				(lowerRoll init:)
			)
			(3 (self dispose:))
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(pEvent localize:)
		(= pEventX (pEvent x?))
		(= pEventY (pEvent y?))
		(= temp0 (== (gIconBar curIcon?) (gIconBar at: 1)))
		(return
			(cond 
				(
					(and
						(!= (pEvent type?) evVERB)
						(not (pEvent modifiers?))
					)
					(cond 
						((& (pEvent type?) $0044)
							(if temp0
								(cond 
									((== (pEvent message?) KEY_RETURN)
										(if
											(or
												(upperRoll onMe: pEvent)
												(lowerRoll onMe: pEvent)
												(ProphesyScroll onMe: pEvent)
											)
											(if (not (theGPseudoMouse handleEvent: pEvent))
												(return 0)
											)
										else
											(pEvent claimed: 1)
											(if (== state 2) (self cue:))
										)
									)
									((not (theGPseudoMouse handleEvent: pEvent)) (return 0))
								)
							else
								(pEvent claimed: 1)
								(switch (pEvent message?)
									(JOY_UP (localproc_007c))
									(JOY_DOWN (localproc_00d7))
									(KEY_TAB
										(return (pEvent claimed: 1))
									)
									(KEY_RETURN
										(cond 
											(
												(or
													(upperRoll onMe: pEvent)
													(lowerRoll onMe: pEvent)
													(ProphesyScroll onMe: pEvent)
												)
												(if (<= pEventY 89)
													(localproc_007c)
												else
													(localproc_00d7)
												)
												(pEvent claimed: 1)
											)
											((== state 2) (self cue:))
										)
										(return 1)
									)
									(KEY_ESCAPE
										(if (== state 2) (self cue:))
									)
									(else 
										(pEvent claimed: 0)
										(if (not (theGPseudoMouse handleEvent: pEvent))
											(return 0)
										)
									)
								)
							)
						)
						((& (pEvent type?) evMOUSEBUTTON)
							(if
								(or
									(upperRoll onMe: pEvent)
									(lowerRoll onMe: pEvent)
									(ProphesyScroll onMe: pEvent)
								)
								(if (== (gIconBar curIcon?) (gIconBar at: 1))
									(if (not (theGPseudoMouse handleEvent: pEvent))
										(return 0)
									)
								else
									(if (<= pEventY 89)
										(localproc_007c)
									else
										(localproc_00d7)
									)
									(pEvent claimed: 1)
								)
							else
								(pEvent claimed: 1)
								(if (== state 2) (self cue:))
							)
							(return 1)
						)
					)
				)
				((not (theGPseudoMouse handleEvent: pEvent)) (return 0))
			)
		)
	)
)

(instance fdc of Code
	(properties)
	
	(method (doit param1)
		(if (param1 respondsTo: #delete)
			(param1
				signal: (& (param1 signal?) $ffdf)
				dispose:
				delete:
			)
		else
			(param1 dispose:)
		)
	)
)

(instance aList of Collect
	(properties)
)

(instance fList of Collect
	(properties)
)

(instance cList of Collect
	(properties)
)

(instance ProphesyScroll of EcoView
	(properties
		x 159
		y 164
		view 144
		priority 3
		signal $4011
	)
	
	(method (init)
		(if gProphesyScrollY
			(= y (= y gProphesyScrollY))
		else
			(= y (= y 132))
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(if (<= pEventY 89)
					(localproc_007c)
				else
					(localproc_00d7)
				)
			)
			(1
				(EcoNarrator
					posn: -1 10
					init: 1 0 0 (localproc_0132) 0 816
				)
			)
		)
	)
	
	(method (onMe param1)
		(proc999_4
			(ProphesyScroll nsLeft?)
			(upperRoll nsTop?)
			(ProphesyScroll nsRight?)
			(lowerRoll nsBottom?)
			param1
		)
	)
)

(instance upperRoll of EcoProp
	(properties
		x 160
		y 52
		view 145
		cel 2
		priority 15
		signal $1011
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (localproc_007c))
			(1
				(EcoNarrator init: 1 0 0 11 0 816)
			)
		)
	)
)

(instance lowerRoll of EcoProp
	(properties
		x 160
		y 153
		view 145
		loop 1
		cel 1
		priority 15
		signal $1011
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (localproc_00d7))
			(1
				(EcoNarrator init: 1 0 0 11 0 816)
			)
		)
	)
)
