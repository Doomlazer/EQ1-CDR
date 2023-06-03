;;; Sierra Script 1.0 - (do not remove this comment)
(script# 121)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Cycle)
(use Obj)

(public
	beginQuest 0
)

(local
	[local0 2] = [10]
)
(instance beginQuest of Script
	(properties)
	
	(method (dispose)
		(balloons setCycle: 0 dispose: delete:)
		(super dispose:)
		(DisposeScript 121)
	)
	
	(method (changeState newState &tmp [temp0 500])
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_7)
				(proc819_6 7)
				(gEgo ignoreHorizon: setPri: 7 posn: 198 109)
				(gDelph
					init:
					loop: 6
					cel: 0
					x: 149
					y: 106
					z: 0
					setPri: 15
				)
				(= cycles 10)
			)
			(1
				((ScriptID 2 0) init: 1 0 0 15 0 self)
			)
			(2
				((ScriptID 2 0) init: 1 0 0 16 1 self)
			)
			(3
				(gDelph setMotion: MoveTo -70 90)
				(= cycles 1)
			)
			(4
				(balloons
					init:
					ignoreHorizon:
					setCycle: Fwd
					setMotion: MoveTo -21 12 self
				)
				(= cycles 20)
			)
			(5
				(proc819_9 gEgo balloons self)
			)
			(6
				(EcoNarrator posn: 10 100 talkWidth: 150 init: 3 0 0 54)
			)
			(7
				(proc0_2)
				(gDelph dispose:)
				(self dispose:)
			)
		)
	)
)

(instance balloons of EcoActor
	(properties
		x 334
		y 57
		view 126
		priority 3
		signal $4810
		cycleSpeed 13
		xStep 6
	)
)
