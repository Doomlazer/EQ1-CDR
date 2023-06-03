;;; Sierra Script 1.0 - (do not remove this comment)
(script# 141)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Cycle)
(use Obj)

(public
	useTrident 0
	trident 1
)

(instance useTrident of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 141)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(Load rsSOUND 144 165)
				(proc0_4 10 255)
				(if (gFeatures contains: (ScriptID 140 1))
					((ScriptID 140 1) dispose:)
					((ScriptID 140 2) dispose:)
				)
				(if (proc819_5 30)
					(= next (ScriptID 140 11))
					(= state 8)
				)
				(= cycles 1)
			)
			(1
				(if (not global87)
					(trident cycleSpeed: 5)
				else
					(trident cycleSpeed: 8)
				)
				(trident init: setCycle: CT 4 1 self)
			)
			(2 (= cycles 5))
			(3
				(gSoundEffects number: 144 loop: 1 play:)
				(trident setCycle: End self)
			)
			(4 (trident setCycle: Beg self))
			(5
				(trident hide: setCycle: 0 dispose: delete:)
				(= cycles 3)
			)
			(6
				(if (gCast contains: (ScriptID 140 12))
					(gSoundEffects number: 165 loop: 1 play:)
					(ShakeScreen 7 2)
					((ScriptID 140 12)
						setLoop: 1
						cel: 0
						cycleSpeed: 7
						setCycle: End self
					)
				else
					(self changeState: 8)
				)
			)
			(7
				((ScriptID 140 12) hide: setCycle: 0 dispose: delete:)
				(= cycles 3)
			)
			(8
				(UnLoad 128 155)
				(EcoNarrator
					posn: -1 5
					talkWidth: -1
					init: 4 0 0 4 self 140
				)
			)
			(9
				((ScriptID 140 3) init:)
				((ScriptID 140 4)
					cel: 1
					setMotion:
						MoveTo
						((ScriptID 140 4) x?)
						(- ((ScriptID 140 4) nsTop?) 1)
						self
				)
			)
			(10
				(gSoundEffects stop:)
				((ScriptID 140 4) hide:)
				(self setScript: (ScriptID 140 5) self)
			)
			(11
				(cond 
					((proc819_5 73) (self setScript: (ScriptID 140 6) self))
					((proc819_5 31) (gEgo setScript: (ScriptID 140 21)) (= cycles 1))
					((and (proc819_5 4) (not (gEgo has: 2))) (self setScript: (ScriptID 140 8) self))
					(else
						(proc0_2)
						(gIconBar disable: 0)
						(if (proc819_5 29)
							(= cycles 1)
						else
							(self setScript: firstTalk self)
						)
					)
				)
			)
			(12 (= cycles 2))
			(13 (self dispose:))
		)
	)
)

(instance firstTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator
					posn: -1 5
					talkWidth: -1
					init: 4 0 0 30 self 140
				)
			)
			(1
				((ScriptID 140 9) init: 2 0 0 1 1 self 140)
			)
			(2 (self dispose:))
		)
	)
)

(instance trident of EcoProp
	(properties
		x 143
		y 113
		z 17
		view 141
		priority 15
		signal $4010
	)
)
