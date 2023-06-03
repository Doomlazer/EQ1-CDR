;;; Sierra Script 1.0 - (do not remove this comment)
(script# 70)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use RangeOsc)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Cycle)

(public
	getWater 0
	getBeaker 1
	getSodaCan 2
	getEnvelope 3
	getEnvelopeToToss 4
	disposeSodaCan 5
)

(local
	[local0 78] = [0 83 124 0 109 128 6 141 123 6 165 105 6 189 87 0 222 83 0 255 90 2 282 102 2 299 121 3 301 143 1 273 161 5 230 156 5 210 132 5 196 108 5 182 89 5 162 60 5 140 39 1 107 24 1 67 25 3 37 40 7 24 60 7 14 85 7 11 111 7 11 135 7 10 149 -1]
)
(instance plane of EcoActor
	(properties
		x 60
		y 118
		yStep 6
		view 415
		loop 5
		priority 15
		signal $6810
		illegalBits $0000
		xStep 6
		moveSpeed 0
	)
)

(instance getWater of HandsOffScript
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 70)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setHeading: 0 self get: 14)
			)
			(1
				(gEgo view: 402 loop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(EcoNarrator posn: 160 20 init: 3 0 2 3 self)
				(proc0_4 2 215)
				(register startUpd: dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(proc819_6 3)
				(self dispose:)
			)
		)
	)
)

(instance getBeaker of HandsOffScript
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 70)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setHeading: 0 self get: 13)
			)
			(1
				(gEgo view: 402 loop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(register startUpd: dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(proc819_6 3)
				(self dispose:)
			)
		)
	)
)

(instance getSodaCan of HandsOffScript
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 70)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setHeading: 0 self get: 10)
			)
			(1
				(gEgo view: 402 loop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(register startUpd: dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(proc0_4 2 213)
				(EcoNarrator posn: 160 20 init: 3 0 0 67 self)
			)
			(4
				(proc819_6 3)
				(self dispose:)
			)
		)
	)
)

(instance getEnvelope of HandsOffScript
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 70)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(Load rsVIEW 415)
				(proc819_3 64)
				(proc0_4 5 204)
				(gEgo setHeading: 0 self get: 12 get: 11)
			)
			(1
				(gEgo view: 415 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(register startUpd: hide:)
				(gEgo setCycle: End self)
			)
			(3
				((ScriptID 2 1) init: 2 0 0 8 1 self)
			)
			(4
				(gEgo loop: 1 cel: 0 setCycle: CT 12 1 self)
			)
			(5
				(register show: setCel: 1)
				(gEgo setCycle: End self)
			)
			(6
				(register stopUpd:)
				(proc819_6 0)
				(self dispose:)
			)
		)
	)
)

(instance getEnvelopeToToss of HandsOffScript
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 70)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc819_3 108)
				(Load rsVIEW 415)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 415 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(register startUpd: dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(EcoNarrator posn: 160 20 init: 3 0 0 68 self)
			)
			(4
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(gEgo loop: 4 cel: 0 setCycle: CT 3 1 self)
			)
			(6
				(gEgo setCycle: End)
				(= register (= register 0))
				(proc819_6 0)
				(plane init:)
				(= cycles (= cycles 1))
			)
			(7
				(plane
					setCel: [local0 (* 3 register)]
					setMotion:
						MoveTo
						[local0 (+ (* 3 register) 1)]
						[local0 (+ (* 3 register) 2)]
						self
				)
			)
			(8
				(if (!= [local0 (* 3 (++ register))] -1)
					(= state (= state (- state 2)))
				)
				(if (== [local0 (+ (* 3 register) 1)] 301)
					((ScriptID 400 8) setCycle: RangeOsc 1 0 0)
				)
				(= ticks (= ticks 3))
			)
			(9
				(plane dispose:)
				((ScriptID 400 8) stopUpd:)
				(proc0_4 5 205)
				(= cycles (= cycles 3))
			)
			(10
				((ScriptID 2 1) init: 2 0 0 28 0 self)
			)
			(11
				((ScriptID 2 1) init: 2 0 0 29 1 self)
			)
			(12 (self dispose:))
		)
	)
)

(instance disposeSodaCan of HandsOffScript
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 70)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(Load rsVIEW 406)
				(gEgo setHeading: 0 self put: 10)
			)
			(1
				(proc819_3 63)
				(gEgo
					view: 406
					loop: 0
					cel: 0
					cycleSpeed: (+ (gEgo cycleSpeed?) 7)
					setCycle: CT 7 1 self
				)
			)
			(2
				(gSoundEffects number: 404 loop: 1 play:)
				(gEgo
					cycleSpeed: (- (gEgo cycleSpeed?) 7)
					setCycle: End self
				)
			)
			(3
				(gSoundEffects number: 405 loop: 1 play:)
				(proc819_6 3)
				(= cycles (= cycles 5))
			)
			(4
				((ScriptID 2 1) init: 2 0 0 29 1 self)
			)
			(5
				(proc0_4 5 214)
				(self dispose:)
			)
		)
	)
)
