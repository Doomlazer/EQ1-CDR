;;; Sierra Script 1.0 - (do not remove this comment)
(script# 66)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use StopWalk)
(use Cycle)
(use Obj)

(public
	lookAtDirtyBirdy 0
	lookAtCleanBirdy 3
)

(instance lookAtDirtyBirdy of Script
	(properties)
	
	(method (dispose)
		(proc819_4 149)
		(super dispose: &rest)
		(DisposeScript 66)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(proc819_3 149)
				(proc819_3 125)
				(gEgo setMotion: PolyPath 211 123 self)
				((ScriptID 400 1) setScript: 0)
			)
			(1 (gEgo setHeading: 270 self))
			(2
				((ScriptID 400 1) setHeading: 90 self)
			)
			(3
				(if (proc819_5 126)
					(if (>= register 0)
						(= ticks (= ticks 3))
					else
						(EcoNarrator posn: -1 140 init: 3 0 0 18 self)
					)
				else
					((ScriptID 2 1) init: 2 0 0 3 1 self)
				)
			)
			(4
				(if (or (proc819_5 126) (>= register 0))
					(= state (= state (+ state 2)))
					(= ticks (= ticks 1))
				else
					((ScriptID 400 9) init: 1 0 0 8 0 self)
					(proc819_3 126)
				)
			)
			(5
				((ScriptID 400 9) init: 1 0 0 9 0 self)
			)
			(6
				((ScriptID 400 9) init: 1 0 0 10 1 self)
			)
			(7
				(proc819_4 33)
				(bird init:)
				(if (not (gEgo has: 33)) (tRag init:))
				(if (and (not (gEgo has: 18)) (!= global232 2))
					(detergent init:)
				)
				(= cycles (= cycles 6))
			)
			(8
				(proc0_2)
				(gIconBar disable: 0)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(cond 
					((== register -1) (bird doVerb: 1))
					((== register -2) (bird doVerb: 4))
					((== register -3) (bird doVerb: 2))
					(else (bird doVerb: 44 register))
				)
			)
			(9
				(proc0_1)
				(bird hide:)
				(if (not (gEgo has: 33)) (tRag dispose:))
				(if (not (gEgo has: 18)) (detergent dispose: delete:))
				(= cycles (= cycles 3))
			)
			(10
				(bird dispose: delete:)
				(= cycles (= cycles 3))
			)
			(11
				(gEgo startUpd:)
				((ScriptID 400 1) startUpd:)
				(if (or (gEgo has: 18) (== global232 2))
					((ScriptID 400 5) startUpd: hide:)
				)
				(if (gEgo has: 33) ((ScriptID 400 4) startUpd: hide:))
				(= ticks (= ticks 3))
			)
			(12
				(if (or (gEgo has: 18) (== global232 2))
					((ScriptID 400 5) dispose: delete:)
				)
				(if (gEgo has: 33) ((ScriptID 400 4) dispose: delete:))
				(= ticks (= ticks 3))
			)
			(13
				(proc819_3 33)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance lookAtCleanBirdy of Script
	(properties)
	
	(method (dispose)
		(proc819_4 149)
		(super dispose: &rest)
		(DisposeScript 66)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(proc819_3 149)
				(gEgo setMotion: PolyPath 211 123 self)
			)
			(1
				(proc0_2)
				(gIconBar disable: 0)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(gEgo setHeading: 270 self)
			)
			(2
				(bird init:)
				(auxBird init:)
				(beak init: setCycle: Fwd)
				(eye init: setCycle: Fwd)
				(= seconds (= seconds 2))
			)
			(3
				(cond 
					((== register -1) (bird doVerb: 1))
					((== register -2) (bird doVerb: 4))
					((== register -3) (bird doVerb: 2))
					(else (bird doVerb: register))
				)
			)
			(4
				(bird hide:)
				(auxBird hide:)
				(beak hide:)
				(eye hide:)
				(= cycles (= cycles 3))
			)
			(5
				(bird dispose: delete:)
				(auxBird dispose: delete:)
				(beak dispose: delete:)
				(eye dispose: delete:)
				(= cycles (= cycles 3))
			)
			(6
				(gEgo startUpd:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance cleanBird of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo put: 33)
				(bird hide:)
				(= cycles (= cycles 3))
			)
			(1
				(bird dispose: delete:)
				(proc0_4 5 203)
				(= global232 3)
				(= cycles (= cycles 3))
			)
			(2
				((ScriptID 400 9) init: 1 0 0 13 1 self)
			)
			(3
				(proc819_4 33)
				((ScriptID 400 1) setScript: 0)
				(gEgo setMotion: PolyPath 182 113 self)
			)
			(4
				((ScriptID 400 1)
					view: 411
					setLoop: (ScriptID 400 2)
					setCycle: StopWalk 410
					cycleSpeed: 10
					moveSpeed: 10
					setStep: 6 4
					ignoreActors: 1
					setMotion: PolyPath 198 126 self
				)
			)
			(5
				((ScriptID 400 1) setHeading: 315 self)
			)
			(6
				(gEgo view: 407 loop: 0 cel: 0 posn: 182 111)
				((ScriptID 400 3) setCel: 2)
				((ScriptID 400 1)
					view: 407
					loop: 1
					cel: 0
					cycleSpeed: 12
					setCycle: End
				)
				(= seconds (= seconds 3))
			)
			(7
				((ScriptID 400 1)
					loop: 2
					cel: 0
					posn: 198 126
					setCycle: Fwd
				)
				((ScriptID 400 9) init: 1 0 0 14 1 self)
			)
			(8 (= seconds (= seconds 3)))
			(9
				((ScriptID 400 9) init: 1 0 0 15 1 self)
			)
			(10
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(11
				((ScriptID 400 9) init: 1 0 0 27 0 self)
			)
			(12
				((ScriptID 400 9) init: 1 0 0 17 1 self)
			)
			(13
				(gEgo hide:)
				((ScriptID 400 1)
					view: 407
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(14
				(gEgo show: view: 407 loop: 4 cel: 0 cycleSpeed: 20)
				((ScriptID 400 1)
					view: 411
					setLoop: (ScriptID 400 2)
					setCycle: StopWalk 410
					cycleSpeed: 10
					moveSpeed: 10
					setStep: 6 4
					posn: 198 126
					loop: 7
					heading: 315
				)
				(self setScript: rubBird self)
			)
			(15
				(gEgo loop: 6 cel: 0 posn: 182 111)
				(= seconds (= seconds 3))
			)
			(16
				((ScriptID 2 1) init: 2 0 0 5 1 self)
			)
			(17
				((ScriptID 400 9) init: 1 0 0 18 0 self)
			)
			(18
				((ScriptID 400 9) init: 1 0 0 19 1 self)
			)
			(19
				((ScriptID 2 1) init: 2 0 0 6 1 self)
			)
			(20
				((ScriptID 400 9) init: 1 0 0 20 1 self)
			)
			(21
				(gEgo loop: 7 cel: 0 setCycle: End self)
			)
			(22
				((ScriptID 400 3) setCel: 0)
				(proc819_3 10)
				(proc819_6 2)
				(= seconds (= seconds 1))
			)
			(23
				((ScriptID 400 1) setMotion: PolyPath 159 118 self)
			)
			(24
				((ScriptID 400 1) setHeading: 90 self)
			)
			(25
				((ScriptID 400 9) init: 1 0 0 21 1 self)
			)
			(26
				(gEgo posn: 182 113 setMotion: PolyPath 189 118 self)
			)
			(27 (gEgo setHeading: 270 self))
			(28
				(gEgo
					view: 427
					posn: 178 117
					ignoreActors: 1
					cel: 0
					loop: 4
				)
				((ScriptID 400 6) startUpd: dispose:)
				(gEgo get: 13)
				((ScriptID 400 1)
					view: 427
					loop: 3
					cel: 0
					posn: 178 117
					ignoreActors: 1
					setCycle: CT 3 1 self
				)
			)
			(29
				(gEgo setCycle: CT 4 1 self)
			)
			(30
				(gEgo setCycle: End)
				((ScriptID 400 1) setCycle: End self)
			)
			(31
				(proc0_4 2 208)
				((ScriptID 400 9) init: 1 0 0 22 0 self)
			)
			(32
				((ScriptID 400 9) init: 1 0 0 23 1 self)
			)
			(33
				(proc819_6 1)
				(gEgo posn: 189 118)
				((ScriptID 400 1)
					view: 411
					setLoop: (ScriptID 400 2)
					setCycle: StopWalk 410
					cycleSpeed: 10
					moveSpeed: 10
					setStep: 6 4
					posn: 159 118
					loop: 0
					heading: 90
					setMotion: PolyPath 133 150 self
				)
			)
			(34
				((ScriptID 400 1) setHeading: 45 self)
			)
			(35
				((ScriptID 400 9) init: 1 0 0 24 1 self)
			)
			(36
				((ScriptID 2 1) init: 2 0 0 7 1 self)
			)
			(37
				((ScriptID 400 9) init: 1 0 0 25 0 self)
			)
			(38
				((ScriptID 400 9) init: 1 0 0 26 1 self)
			)
			(39
				((ScriptID 400 1) setMotion: MoveTo -16 225 self)
			)
			(40
				((ScriptID 400 1) dispose:)
				(proc0_1)
				(lookAtDirtyBirdy cue:)
				(self dispose:)
			)
		)
	)
)

(instance getRag of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo get: 33)
				(tRag dispose:)
				((ScriptID 400 4) startUpd: hide:)
				(= cycles (= cycles 6))
			)
			(1
				(EcoNarrator posn: -1 140 init: 3 0 0 72 self 400)
			)
			(2
				((ScriptID 400 4) dispose: delete:)
				(proc0_4 2 200)
				(proc0_2)
				(gIconBar disable: 0)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(self dispose:)
			)
		)
	)
)

(instance getDetergent of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo get: 18)
				(detergent dispose: delete:)
				((ScriptID 400 5) startUpd: hide:)
				(= cycles (= cycles 6))
			)
			(1
				(EcoNarrator posn: -1 140 init: 3 0 0 73 self 400)
			)
			(2
				((ScriptID 400 5) dispose: delete:)
				(proc0_4 2 201)
				(proc0_2)
				(gIconBar disable: 0)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(self dispose:)
			)
		)
	)
)

(instance rubBird of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(if (< (++ register) 27) (= state (= state -1)))
				(gSoundEffects number: 402 loop: 1 play:)
				(gEgo cel: (mod register 9))
				(= cycles (= cycles 5))
			)
			(1
				(= register (= register 0))
				(self dispose:)
			)
		)
	)
)

(instance beak of EcoProp
	(properties
		z 100
		view 404
		loop 5
		priority 14
		signal $4011
		cycleSpeed 20
	)
	
	(method (init)
		(self posn: (+ (auxBird x?) 19) (+ (auxBird y?) -1))
		(super init: &rest)
	)
	
	(method (doVerb)
		(bird doVerb: &rest)
	)
)

(instance eye of EcoProp
	(properties
		z 100
		view 404
		loop 4
		priority 15
		signal $4011
		cycleSpeed 30
	)
	
	(method (init)
		(self posn: (+ (auxBird x?) 18) (+ (auxBird y?) -2))
		(super init: &rest)
	)
	
	(method (doVerb)
		(bird doVerb: &rest)
	)
)

(instance bird of EcoProp
	(properties
		x 100
		y 153
		z 100
		view 404
		priority 14
		signal $5011
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
			(4
				(if (proc819_5 10)
					(EcoNarrator posn: -1 140 init: 3 0 0 51)
				else
					(EcoNarrator posn: -1 140 init: 3 0 0 4)
				)
			)
			(1
				(if (proc819_5 10)
					(EcoNarrator posn: -1 140 init: 3 0 0 19)
				else
					(EcoNarrator posn: -1 140 init: 3 0 0 1)
				)
			)
			(2
				((ScriptID 2 1) init: 2 0 0 35 1)
			)
			(44
				(switch temp0
					(42
						(cond 
							((proc819_5 10) (EcoNarrator posn: -1 140 init: 3 0 0 51))
							((== global232 2) (gEgo setScript: cleanBird))
							(else ((ScriptID 400 9) init: 1 0 0 28 1))
						)
					)
					(27
						(EcoNarrator posn: -1 140 init: 3 0 0 88)
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

(instance auxBird of EcoProp
	(properties
		z 100
		view 404
		loop 1
		priority 15
		signal $4011
		lookStr 23
	)
	
	(method (init)
		(super init:)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
		(self posn: (+ (bird x?) 30) (+ (bird y?) 26))
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (doVerb)
		(bird doVerb: &rest)
	)
)

(instance tRag of EcoProp
	(properties
		x 109
		y 207
		z 100
		view 404
		loop 3
		priority 15
		signal $4011
		lookStr 21
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
		(switch theVerb
			(1
				(EcoNarrator posn: -1 140 init: 3 0 0 lookStr self)
			)
			(4 (bird setScript: getRag))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance detergent of EcoProp
	(properties
		x 132
		y 204
		z 100
		view 404
		loop 2
		priority 15
		signal $4011
		lookStr 20
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
			(1
				(EcoNarrator posn: -1 140 init: 3 0 0 lookStr self)
			)
			(4
				(bird setScript: getDetergent)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)
