;;; Sierra Script 1.0 - (do not remove this comment)
(script# 68)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Cycle)
(use User)
(use Obj)

(public
	lookAtTank 0
	lookAtBlackBoard 1
	biteFinger 2
)

(instance cleanTank of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc0_4 5 212)
				(= seconds 2)
			)
			(1
				(EcoNarrator posn: 70 150 init: 3 0 0 94 self)
			)
			(2 (oil setCycle: End self))
			(3
				(oil dispose: delete:)
				(= seconds 2)
			)
			(4
				(EcoNarrator posn: 70 150 init: 3 0 0 17 self)
			)
			(5
				(proc819_3 16)
				(proc0_2)
				(gIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance lookAtTank of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 68)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 6))
			(1
				(fishTankInset init:)
				(if (not (proc819_5 16)) (oil init:))
				(= cycles 6)
			)
			(2
				(proc0_2)
				(gIconBar disable: 0)
				(switch register
					(-1 (fishTankInset doVerb: 1))
					(-2 (fishTankInset doVerb: 4))
					(else 
						(fishTankInset doVerb: register)
					)
				)
			)
			(3
				(proc0_1)
				(fishTankInset hide:)
				(if (not (proc819_5 16)) (oil hide:))
				(= cycles 3)
			)
			(4
				(fishTankInset dispose: delete:)
				(if (not (proc819_5 16)) (oil dispose: delete:))
				(= cycles 3)
			)
			(5 (proc0_2) (self dispose:))
		)
	)
)

(instance lookAtBlackBoard of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 68)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 1 canInput: 1)
				(gIconBar disable: 5 0 2 3 4 5)
				(if (proc819_5 15) (gIconBar disable: 6))
				(blackBoardInset init:)
				(gIconBar disable: 0)
				(= cycles 2)
			)
			(1
				(proc0_4 5 210)
				(switch register
					(-1 (blackBoardInset doVerb: 1))
					(-2 (blackBoardInset doVerb: 4))
					(else 
						(blackBoardInset doVerb: register)
					)
				)
			)
			(2
				(proc0_1)
				(blackBoardInset hide:)
				(= cycles 3)
			)
			(3
				(blackBoardInset dispose: delete:)
				(= cycles 3)
			)
			(4 (proc0_2) (self dispose:))
		)
	)
)

(instance fishTankInset of EcoProp
	(properties
		x 104
		y 206
		z 200
		view 405
		priority 13
		signal $4010
	)
	
	(method (init)
		(super init:)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (pEvent claimed?))
				(gUser controls?)
				(gUser input?)
				(!= (pEvent type?) evVERB)
				(not (& (pEvent type?) $000a))
				(!= (pEvent message?) KEY_TAB)
				(not (self onMe: pEvent))
				(not (pEvent modifiers?))
			)
			(pEvent claimed: 1)
			((global2 script?) cue:)
		else
			(super handleEvent: pEvent &rest)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 16)
					(EcoNarrator posn: 70 150 init: 3 0 0 16)
				else
					(EcoNarrator posn: 70 150 init: 3 0 0 14)
				)
			)
			(4
				(if (proc819_5 16)
					(EcoNarrator posn: 70 150 init: 3 0 0 63)
				else
					(EcoNarrator posn: 70 150 init: 3 0 0 62)
				)
			)
			(44
				(if (== temp0 22)
					(if (proc819_5 16)
						((ScriptID 2 1) init: 2 0 0 36 1)
					else
						(fishTankInset setScript: cleanTank)
					)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance oil of EcoProp
	(properties
		x 160
		y 187
		z 100
		view 405
		loop 1
		priority 14
		signal $4010
		cycleSpeed 20
		lookStr 13
	)
	
	(method (init)
		(super init:)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(fishTankInset doVerb: theVerb temp0 &rest)
			)
			(1
				(fishTankInset doVerb: theVerb temp0 &rest)
			)
			(44
				(if (== temp0 13)
					(if (proc819_5 16)
						(EcoNarrator posn: 70 150 init: 3 0 0 17)
					else
						(fishTankInset setScript: cleanTank)
					)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance blackBoardInset of EcoProp
	(properties
		x 140
		y 198
		z 200
		view 413
		priority 14
		signal $4010
	)
	
	(method (init)
		(super init:)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (pEvent claimed?))
				(gUser controls?)
				(gUser input?)
				(!= (pEvent type?) evVERB)
				(not (& (pEvent type?) $000a))
				(!= (pEvent message?) KEY_TAB)
				(not (self onMe: pEvent))
				(not (pEvent modifiers?))
			)
			(pEvent claimed: 1)
			((global2 script?) cue:)
		else
			(super handleEvent: pEvent &rest)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((proc999_4 228 35 270 85 gPEventX gPEventY) (EcoNarrator posn: 70 150 init: 3 0 0 36))
					((proc999_4 169 33 221 60 gPEventX gPEventY) (EcoNarrator posn: 70 150 init: 3 0 0 34))
					((proc999_4 169 57 221 87 gPEventX gPEventY) (EcoNarrator posn: 70 150 init: 3 0 0 35))
					(else (EcoNarrator posn: 70 150 init: 3 0 0 33))
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance biteFinger of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 68)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 414 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				((ScriptID 400 8) startUpd: setCycle: End self)
			)
			(3 (gEgo setCycle: End self))
			(4
				((ScriptID 400 8) setCycle: Beg self)
			)
			(5
				(EcoNarrator posn: 70 -110 init: 3 0 0 29 self)
			)
			(6
				((ScriptID 400 8) stopUpd:)
				(proc819_6 0)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)
