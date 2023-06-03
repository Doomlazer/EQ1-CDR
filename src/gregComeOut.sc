;;; Sierra Script 1.0 - (do not remove this comment)
(script# 202)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Cycle)
(use Obj)

(public
	gregComeOut 0
	getStarFish 1
)

(instance gregComeOut of Script
	(properties)
	
	(method (dispose)
		(super dispose:)
		(DisposeScript 202)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(= start 0)
				(self setScript: (ScriptID 200 5) self)
			)
			(1
				(if (not (proc819_3 39))
					(proc0_4 2 277)
					(= cycles 1)
				else
					(= state 10)
					(= cycles 1)
				)
			)
			(2
				(proc819_9 gEgo (ScriptID 200 7) self)
			)
			(3
				((ScriptID 200 3) init: 1 0 0 2 1 self)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(5
				((ScriptID 200 3) init: 1 0 0 3 1 self)
			)
			(6
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(7
				((ScriptID 200 3) init: 1 0 0 4 1 self)
			)
			(8
				((ScriptID 2 1) init: 2 0 0 3 1 self)
			)
			(9
				((ScriptID 200 3) init: 1 0 0 5 1 self)
			)
			(10
				(if (gCast contains: gDelph)
					((ScriptID 2 0) init: 3 0 0 1 1 self)
				else
					(= cycles 1)
				)
				(= state 11)
			)
			(11
				((ScriptID 200 3) init: 1 0 0 6 1 self)
			)
			(12
				(self setScript: gregWait self)
			)
			(13
				(if (gCast contains: (ScriptID 200 7))
					(self setScript: (ScriptID 200 4) self)
				else
					(= cycles 1)
				)
			)
			(14 (proc0_2) (self dispose:))
		)
	)
)

(instance gregWait of Script
	(properties)
	
	(method (doit)
		(if (not ((ScriptID 200 7) script?)) (super doit:))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gIconBar disable: 0)
				((ScriptID 200 7) setCycle: Fwd)
				(= seconds 20)
			)
			(1
				((ScriptID 200 3) init: 1 0 0 8 1 self)
			)
			(2 (proc0_1) (self dispose:))
		)
	)
)

(instance getStarFish of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 1) init: 2 0 0 21 1 self)
			)
			(1
				(if (and (!= (gEgo x?) 200) (!= (gEgo y?) 88))
					(gEgo setMotion: MoveTo 200 88 self)
				else
					(= cycles 1)
				)
			)
			(2 (= cycles 12))
			(3
				((ScriptID 200 7)
					view: 248
					loop: 1
					cel: 0
					posn: 167 95
					ignoreActors:
					cycleSpeed: 18
					setCycle: CT 2 1
				)
				(gEgo
					setCycle: 0
					view: 248
					loop: 0
					cel: 0
					posn: 196 87
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(4
				(proc0_4 5 278)
				((ScriptID 200 9) approachX: 186 approachY: 109)
				(gEgo put: 1 200)
				(gEgo
					view: 805
					setLoop: 1
					setHeading: 270
					posn: 200 88
					cycleSpeed: 7
					setCycle: Fwd
				)
				(= cycles 12)
			)
			(5
				((ScriptID 200 7) setCycle: End self)
			)
			(6
				((ScriptID 200 3) init: 1 0 0 9 1 self)
			)
			(7
				(self setScript: (ScriptID 200 4) self)
			)
			(8
				(proc0_1)
				(EcoNarrator init: 4 0 0 48)
				(= cycles 2)
			)
			(9
				(baggie
					init:
					illegalBits: 0
					setLoop: 9
					setCycle: Fwd
					setMotion: MoveTo 141 58 self
				)
				(gEgo cycleSpeed: 6)
			)
			(10
				(EcoNarrator init: 4 0 0 49 self)
			)
			(11
				(baggie dispose:)
				(gSoundEffects number: 210 loop: 1 play:)
				((ScriptID 200 6)
					init:
					illegalBits: 0
					setPri: 2
					posn: 105 64
					cel: 1
					setCycle: CT 6 1 self
				)
			)
			(12
				(gSoundEffects number: 211 loop: 1 play:)
				((ScriptID 200 6) setCycle: End self)
			)
			(13
				((ScriptID 200 6)
					view: 223
					loop: 1
					cel: 0
					x: 144
					y: 66
					setPri: -1
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(14
				(EcoNarrator init: 4 0 0 50 self)
			)
			(15
				((ScriptID 200 6)
					view: 223
					loop: 2
					cel: 0
					cycleSpeed: 17
					setCycle: CT 3 1 self
				)
			)
			(16
				(gSoundEffects number: 212 loop: 1 play:)
				((ScriptID 200 6) cel: 4)
				(= cycles 8)
			)
			(17
				((ScriptID 200 6)
					view: 223
					loop: 3
					cel: 0
					x: 122
					y: 72
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(18
				((ScriptID 200 6)
					view: 223
					loop: 4
					cel: 0
					x: 84
					y: 70
					cycleSpeed: 4
					setCycle: Fwd
				)
				(proc819_3 47)
				(= cycles 1)
			)
			(19
				(EcoNarrator init: 4 0 0 51 self)
			)
			(20
				(proc819_6)
				(gEgo setHeading: 270 posn: 200 88 setPri: 6)
				(= cycles 12)
			)
			(21 (proc0_2) (self dispose:))
		)
	)
)

(instance baggie of EcoActor
	(properties
		x 168
		y -8
		view 223
		loop 9
		priority 5
		signal $6010
	)
)
