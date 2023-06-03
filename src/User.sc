;;; Sierra Script 1.0 - (do not remove this comment)
(script# 996)
(include sci.sh)
(use Main)
(use Obj)


(instance uEvt of Event
	(properties)
	
	(method (new)
		(= type
			(= message
				(= modifiers (= y (= x (= claimed (= port 0)))))
			)
		)
		(GetEvent 32767 self)
		(return self)
	)
)

(class User of Obj
	(properties
		alterEgo 0
		input 0
		controls 0
		prevDir 0
		x -1
		y -1
		mapKeyToDir 1
		curEvent 0
	)
	
	(method (init)
		(= curEvent uEvt)
	)
	
	(method (doit)
		(curEvent new:)
		(self handleEvent: curEvent)
	)
	
	(method (canControl theControls)
		(if argc (= controls theControls) (= prevDir 0))
		(return controls)
	)
	
	(method (handleEvent pEvent &tmp pEventType pEventMessage pEventModifiers temp3 temp4)
		(= gPEventX (pEvent x?))
		(= gPEventY (pEvent y?))
		(= pEventType (pEvent type?))
		(= pEventModifiers (pEvent modifiers?))
		(if pEventType
			(= gPEvent pEvent)
			(if mapKeyToDir (MapKeyToDir pEvent))
			(if (== pEventType evJOYDOWN)
				(= pEventType 4)
				(= pEventMessage
					(if (& pEventModifiers emSHIFT) 27 else 13)
				)
				(= pEventModifiers 0)
				(pEvent
					type: pEventType
					message: pEventMessage
					modifiers: pEventModifiers
				)
			)
			(if (and global75 (global75 handleEvent: pEvent))
				(return 1)
			)
			(if (and global92 (global92 handleEvent: pEvent))
				(return 1)
			)
			(pEvent localize:)
			(= pEventType (pEvent type?))
			(= pEventMessage (pEvent message?))
			(cond 
				((& pEventType evSAID)
					(cond 
						(
							(and
								(== pEventMessage JOY_UP)
								(or
									(= temp4 (gCast firstTrue: #perform findNoun))
									(= temp4 (gFeatures firstTrue: #perform findNoun))
									(= temp4 (gAddToPics firstTrue: #perform findNoun))
								)
							)
							(temp4 doVerb: ((gIconBar curIcon?) message?))
						)
						((= temp4 (gIconBar findIcon: pEventMessage))
							(gIconBar select: temp4)
							(gGame setCursor: (temp4 cursor?))
						)
					)
				)
				((& pEventType evJOYSTICK)
					(cond 
						(
							(and
								gEcoDirectionHandler
								(gEcoDirectionHandler handleEvent: pEvent)
							)
							(return 1)
						)
						(
							(and
								(or
									(and
										gIconBar
										(== (gIconBar curIcon?) (gIconBar walkIconItem?))
									)
									(not gIconBar)
								)
								alterEgo
								controls
								(gCast contains: alterEgo)
								(alterEgo handleEvent: pEvent)
							)
							(return 1)
						)
						(
							(and
								gPseudoMouse
								input
								(or
									(not (& pEventType evKEYBOARD))
									(!= pEventMessage JOY_NULL)
								)
								(gPseudoMouse handleEvent: pEvent)
							)
							(return 1)
						)
					)
				)
				(
					(and
						(& pEventType evKEYBOARD)
						gEcoKeyDownHandler
						(gEcoKeyDownHandler handleEvent: pEvent)
					)
					(return 1)
				)
				(
					(and
						(& pEventType evMOUSEBUTTON)
						gEcoMouseDownHandler
						(gEcoMouseDownHandler handleEvent: pEvent)
					)
					(return 1)
				)
			)
		)
		(if (& pEventType evMOUSERELEASE)
			(= pEventType 0)
			(pEvent type: 0)
			(pEvent claimed: 1)
		)
		(if gIconBar (gIconBar handleEvent: pEvent))
		(= pEventType (pEvent type?))
		(= pEventMessage (pEvent message?))
		(if (and input (& pEventType evVERB))
			(cond 
				(
					(and
						(& pEventType evMOVE)
						gWalkHandler
						(gWalkHandler handleEvent: pEvent)
					)
					(return 1)
				)
				(
					(and
						(& pEventType evMOVE)
						(gCast contains: alterEgo)
						controls
						(alterEgo handleEvent: pEvent)
					)
					(return 1)
				)
				(global34
					(OnMeAndLowY init:)
					(gCast eachElementDo: #perform OnMeAndLowY pEvent)
					(gFeatures eachElementDo: #perform OnMeAndLowY pEvent)
					(gAddToPics eachElementDo: #perform OnMeAndLowY pEvent)
					(if
						(and
							(OnMeAndLowY theObj?)
							((OnMeAndLowY theObj?) handleEvent: pEvent)
						)
						(return 1)
					)
				)
				((gCast handleEvent: pEvent) (return 1))
				((gFeatures handleEvent: pEvent) (return 1))
			)
			(if
				(and
					(not (pEvent claimed?))
					(gRegions handleEvent: pEvent)
				)
				(return 1)
			)
		)
		(if pEventType
			(cond 
				((gGame handleEvent: pEvent) (return 1))
				((and global92 (global92 handleEvent: pEvent)) (return 1))
			)
		)
		(return 0)
	)
	
	(method (canInput theInput)
		(if argc (= input theInput))
		(return input)
	)
)

(class OnMeAndLowY of Code
	(properties
		theObj 0
		lastY -1
	)
	
	(method (init)
		(= theObj 0)
		(= lastY -1)
	)
	
	(method (doit theTheObj param2)
		(if
		(and (theTheObj onMe: param2) (> (theTheObj y?) lastY))
			(= lastY ((= theObj theTheObj) y?))
		)
	)
)

(instance findNoun of Code
	(properties)
	
	(method (doit param1 param2)
		(return (== (param1 noun?) param2))
	)
)
