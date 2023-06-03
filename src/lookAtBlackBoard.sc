;;; Sierra Script 1.0 - (do not remove this comment)
(script# 69)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Obj)

(public
	lookAtBlackBoard 0
	lookAtCage 1
)

(local
	local0
	local1
)
(instance lookAtBlackBoard of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 69)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(Load rsVIEW 377)
				(proc0_1)
				(blackBoardInset init:)
				((ScriptID gNumber 3) stopUpd:)
				(if (not (proc819_5 122)) (= local1 1) (fris init:))
				(= cycles (= cycles 2))
			)
			(1
				(proc0_2)
				(gIconBar disable: 5 0 3 4 6)
				(switch register
					(-1 (blackBoardInset doVerb: 1))
					(-2 (blackBoardInset doVerb: 4))
				)
			)
			(2
				(proc0_1)
				(blackBoardInset hide:)
				(if (and local1 (not (gEgo has: 15))) (fris hide:))
				(= cycles (= cycles 3))
			)
			(3
				(blackBoardInset dispose: delete:)
				(if (and local1 (not (gEgo has: 15)))
					(fris dispose: delete:)
				)
				(UnLoad 128 377)
				((ScriptID gNumber 3) startUpd:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance lookAtCage of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 69)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(Load rsVIEW 388)
				(proc0_1)
				(cageView init:)
				(gEgo stopUpd:)
				((ScriptID gNumber 3) stopUpd:)
				(= cycles (= cycles 2))
			)
			(1
				(proc0_2)
				(gIconBar disable: 5 0 3 4 6)
				(switch register
					(-1 (cageView doVerb: 1))
					(-2 (cageView doVerb: 4))
				)
			)
			(2
				(proc0_1)
				(cageView startUpd: hide:)
				(= cycles (= cycles 3))
			)
			(3
				(cageView dispose: delete:)
				(= cycles (= cycles 3))
			)
			(4
				(UnLoad 128 388)
				(gEgo startUpd:)
				((ScriptID gNumber 3) startUpd:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance cageView of EcoView
	(properties
		x 149
		y 139
		z 50
		view 388
		priority 14
		signal $4010
		lookStr 47
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
	
	(method (doVerb theVerb)
		(proc0_4 5 241)
		(switch theVerb
			(1
				(EcoNarrator posn: -1 140 init: 5 0 0 lookStr 0 380)
			)
			(4
				(EcoNarrator posn: -1 140 init: 6 0 0 23 0 380)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blackBoardInset of EcoProp
	(properties
		x 110
		y 208
		z 200
		view 377
		priority 14
		signal $4010
		lookStr 104
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
	
	(method (doVerb theVerb)
		(proc0_4 5 239)
		(switch theVerb
			(1
				(EcoNarrator posn: -1 140 init: 6 0 0 4 0 380)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 54 1 0 380)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fris of EcoView
	(properties
		z 200
		view 377
		loop 1
		priority 15
		signal $4010
		lookStr 53
	)
	
	(method (init)
		(= x (= x (+ (blackBoardInset x?) 64)))
		(= y (= y (+ (blackBoardInset y?) 113)))
		(super init: &rest)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gEgo get: 15)
				((ScriptID 380 4) hide: stopUpd:)
				(proc0_4 4 222)
				(proc819_3 122)
				(self dispose:)
			)
			(1
				(EcoNarrator posn: -1 140 init: 5 0 0 lookStr 0 380)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
