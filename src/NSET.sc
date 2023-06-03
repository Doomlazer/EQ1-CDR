;;; Sierra Script 1.0 - (do not remove this comment)
(script# 125)
(include sci.sh)
(use Main)
(use n804)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Cycle)
(use InvI)
(use Obj)

(public
	NSET 0
	Shell 1
	getTrident 2
)

(instance NSET of EcoView
	(properties
		x 218
		y 141
		view 122
		priority 4
		signal $1011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
		(if (not (gEgo has: 20))
			((ScriptID 120 1)
				view: 122
				loop: 1
				cel: 0
				posn: 203 44
				setPri: 5
				approachX: 182
				approachY: 65
			)
		)
		(Shell init: stopUpd:)
		(gEgo
			posn: 214 110
			heading: 0
			loop: 3
			setPri: (+ priority 3)
		)
		(poseidonF init:)
		(Animate (gCast elements?) 0)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (global2 script?))
				(gEgo mover?)
				(not (gEgo inRect: nsLeft nsTop nsRight nsBottom))
			)
			(global2 setScript: disposeTrident)
		)
	)
	
	(method (dispose)
		(proc0_1)
		(self hide:)
		(Shell dispose: delete:)
		(if (not (gEgo has: 20))
			((ScriptID 120 1)
				view: 120
				loop: 5
				cel: 0
				posn: 217 44
				setPri: 3
				stopUpd:
				approachVerbs: 1
				approachX: 213
				approachY: 77
			)
		)
		(poseidonF dispose:)
		(proc819_6 3)
		(gEgo
			ignoreHorizon:
			cel: 0
			heading: 0
			posn: ((ScriptID 120 2) approachX?) ((ScriptID 120 2) approachY?)
			setPri: 7
		)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(if (global2 script?) (global2 setScript: 0))
		(Animate (gCast elements?) 0)
		(super dispose:)
		(self delete:)
		(proc0_2)
		(= global115 0)
		(DisposeScript 125)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(!= (pEvent type?) evVERB)
				(not
					(proc999_5
						(pEvent message?)
						9
						17
						15104
						15360
						16128
						16640
						17152
					)
				)
				(not (& (pEvent type?) $000a))
				(not (self onMe: pEvent))
				(not (pEvent modifiers?))
				(not (global2 script?))
			)
			(pEvent claimed: 1)
			(self dispose:)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator posn: 45 142 init: 3 0 0 43)
			)
			(44
				(switch temp0
					(18
						(global2 setScript: putConchInHands)
					)
					(29
						(EcoNarrator posn: 45 142 init: 3 0 0 97)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance poseidonF of EcoFeature
	(properties
		x 204
		y 43
		nsTop 38
		nsLeft 198
		nsBottom 49
		nsRight 211
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((!= ((Inv at: 20) owner?) 120) (EcoNarrator posn: 45 142 init: 3 0 0 98))
					((== ((Inv at: 9) owner?) 120) (EcoNarrator posn: 45 142 init: 3 0 0 99))
					(else (EcoNarrator posn: 45 142 store: 42 init: 3 0 0 41))
				)
			)
			(2
				(global2 setScript: talkOnPoseidon)
			)
			(4
				(EcoNarrator posn: 45 142 init: 3 0 0 46)
			)
			(44
				(switch temp0
					(18
						(EcoNarrator posn: 45 142 init: 3 0 0 95)
					)
					(29
						(EcoNarrator posn: 45 142 init: 3 0 0 97)
					)
					(else 
						(EcoNarrator posn: 45 142 init: 3 0 0 91)
					)
				)
			)
			(6
				(EcoNarrator posn: 45 142 init: 3 0 0 92)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (onMe param1)
		(if
			(or
				(proc999_4 198 38 211 49 param1)
				(proc999_4 169 49 256 54 param1)
				(proc999_4 189 53 214 87 param1)
			)
		else
			(proc999_4 184 87 192 106 param1)
		)
	)
)

(instance Shell of EcoProp
	(properties
		x 227
		y 89
		view 122
		cel 1
		priority 5
		signal $4010
		lookStr 44
	)
	
	(method (init)
		(super init: &rest)
		(self
			loop: (* (== ((Inv at: 9) owner?) 120) 2)
			cel: (!= ((Inv at: 9) owner?) 120)
			approachX: 259
			approachY: 60
			approachVerbs: 9
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (== ((Inv at: 9) owner?) 120)
					(EcoNarrator posn: 45 142 init: 4 0 0 7)
				else
					(EcoNarrator posn: 45 142 init: 3 0 0 44)
				)
			)
			(44
				(if (== ((Inv at: 9) owner?) 120)
					(EcoNarrator posn: 45 142 init: 4 0 0 4)
				else
					(switch temp0
						(18
							(global2 setScript: putConchInHands)
						)
						(31
							(EcoNarrator posn: 45 142 init: 3 0 0 94)
						)
						(else 
							(EcoNarrator posn: 45 142 init: 3 0 0 93)
						)
					)
				)
			)
			(2
				(if (== ((Inv at: 9) owner?) 120)
					(EcoNarrator posn: 45 142 init: 3 0 0 49)
				else
					(global2 setScript: talkOnPoseidon 0 1)
				)
			)
			(4
				(EcoNarrator posn: 45 142 init: 3 0 0 47)
			)
			(6
				(EcoNarrator posn: 45 142 init: 4 0 0 1)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (onMe param1)
		(if (proc999_4 214 84 243 116 param1)
		else
			(proc999_4 nsLeft nsTop nsRight nsBottom param1)
		)
	)
)

(instance disposeTrident of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1 (proc0_2) (NSET dispose:))
		)
	)
)

(instance putConchInHands of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo
					setMotion: MoveTo (Shell approachX?) (Shell approachY?) self
				)
			)
			(1 (proc819_9 gEgo Shell self))
			(2
				(EcoNarrator posn: 45 142 init: 3 0 0 56 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 122
					setLoop: 4
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(4
				(Shell loop: 2 cel: 0 cycleSpeed: 18)
				(gEgo cel: 4 setCycle: End self)
			)
			(5
				(proc0_4 10 252)
				(gEgo put: 9 120)
				(Shell setCycle: End self)
			)
			(6
				(gSoundEffects number: 646 loop: 1 flags: 1 play: self)
			)
			(7
				(EcoNarrator posn: 45 142 init: 3 0 0 86 self)
			)
			(8
				(Shell setCycle: Beg self)
				((ScriptID 120 1)
					x: (+ ((ScriptID 120 1) x?) 1)
					forceUpd:
				)
			)
			(9
				(gSoundEffects flags: 0)
				(EcoNarrator posn: 45 142 init: 3 0 0 27 self)
			)
			(10
				(proc819_6 1)
				(gEgo ignoreHorizon: setPri: 7)
				(Shell stopUpd:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance getTrident of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 182 65 self)
			)
			(1 (gEgo setHeading: 0 self))
			(2
				((ScriptID 120 1) hide:)
				(gEgo
					setCycle: 0
					view: 122
					setLoop: 3
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(if (== ((Inv at: 9) owner?) 120)
					(gSoundEffects number: 124 loop: 1 play:)
					(gEgo setCycle: End self)
				else
					(EcoNarrator posn: 45 142 init: 3 0 0 26 self)
				)
			)
			(4
				(if (== ((Inv at: 9) owner?) 120)
					(proc0_4 5 253)
					(gEgo get: 20)
					((ScriptID 120 1) dispose:)
					(EcoNarrator posn: 45 142 init: 3 0 0 28 self)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(5
				(proc819_6 3)
				(gEgo
					ignoreHorizon:
					cel: 0
					heading: 0
					posn: ((ScriptID 120 2) approachX?) ((ScriptID 120 2) approachY?)
					setPri: 7
				)
				(proc0_2)
				(if (not (gEgo has: 20))
					((ScriptID 120 1) show:)
					(self dispose:)
					(NSET dispose:)
				else
					(NSET dispose:)
				)
			)
		)
	)
)

(instance talkOnPoseidon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 1) init: 2 0 0 (+ 8 register) 1 self)
			)
			(1
				(EcoNarrator
					posn: 45 142
					init: 3 0 0 (+ 48 register) self
				)
			)
			(2
				(= register 0)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)
