;;; Sierra Script 1.0 - (do not remove this comment)
(script# 62)
(include sci.sh)
(use Main)
(use rm380)
(use n819)
(use RTRandCycle)
(use PolyPath)
(use Cycle)
(use Obj)

(public
	flyDolphin 0
)

(local
	local0 =  3
	[local1 120] = [0 7 34 123 1 0 40 111 1 0 67 96 1 1 92 80 1 1 119 63 1 1 141 44 1 2 171 29 1 2 192 21 1 3 220 19 1 4 246 23 1 5 216 51 1 6 189 59 1 7 142 40 1 7 118 26 1 7 94 12 1 8 61 9 1 8 31 11 1 9 23 15 1 10 31 36 1 0 56 20 1 1 81 5 1 2 104 -4 1 3 135 -7 1 4 162 -2 1 5 126 32 1 5 97 44 1 5 63 57 1 8 30 63 1 11 12 58 1 9 13 92]
)
(instance flyDolphin of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 62)
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc0_4 1 236)
				(Load rsVIEW 384)
				(= global247 18)
				(if (> (gEgo x?) 228)
					(gEgo setMotion: PolyPath 139 82 self)
				else
					(= cycles 1)
				)
			)
			(1
				((ScriptID gNumber 3)
					setCycle: 0
					setScript: 0
					setMotion: MoveTo 26 145 self
				)
			)
			(2
				((ScriptID gNumber 3)
					cycleSpeed: (- ((ScriptID gNumber 3) cycleSpeed?) 35)
					setHeading: 90 self
				)
			)
			(3
				((ScriptID gNumber 3) setCycle: 0)
				(gEgo
					view: 383
					put: 15
					setLoop: 3
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(4
				((ScriptID 380 4)
					startUpd:
					view: 391
					setLoop: (Random 0 7)
					z: 0
					setPri: 6
					ignoreActors: 1
					cel: 0
					setCycle: Fwd
					posn: (- (gEgo y?) 3) (- (gEgo y?) 13)
					show:
					approachVerbs:
					setMotion: (ScriptID 380 7) 49 123 self
				)
			)
			(5
				(gEgo setCycle: End)
				((ScriptID 380 4) hide:)
				((ScriptID gNumber 3)
					view: 390
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(6
				(proc819_6 2)
				((ScriptID 380 1)
					view: 381
					loop: 7
					cel: 0
					posn: (+ (gEgo x?) 1) (- (gEgo y?) 32)
					init:
					setPri: (+ (gEgo priority?) 1)
				)
				(gEgo get: 15 put: 15 360)
				((ScriptID gNumber 3)
					view: 384
					setLoop: 0
					cel: 0
					setPri: 15
					posn: 34 123
					setCycle: End self
				)
				(= register 0)
			)
			(7
				((ScriptID gNumber 3)
					view: 384
					setLoop: [local1 (* register 4)]
					setCel: [local1 (+ (* register 4) 1)]
					posn: [local1 (+ (* register 4) 2)] [local1 (+ (* register 4) 3)]
				)
				(= ticks 6)
			)
			(8
				(if (> (++ register) 29)
					(if (-- local0)
						(= register 0)
						(= state (- state 2))
						(if (== local0 1) (EcoNarrator init: 6 0 0 14))
					)
				else
					(= state (- state 2))
				)
				(= ticks 2)
			)
			(9
				((ScriptID gNumber 3)
					posn: 70 131
					setLoop: 2
					cel: 0
					setPri: 6
					cycleSpeed: 20
					setCycle: CT 11 1 self
				)
			)
			(10
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) setCycle: End self)
			)
			(11
				((ScriptID gNumber 3) hide:)
				(= seconds 3)
			)
			(12
				((ScriptID 380 1) dispose:)
				(proc380_5)
				((ScriptID gNumber 3)
					show:
					posn: 75 154
					setMotion: MoveTo 177 119 self
				)
			)
			(13
				(= global247 17)
				((ScriptID gNumber 3) setScript: (ScriptID 380 6))
				(UnLoad 128 384)
				(= cycles 1)
			)
			(14 (proc0_2) (self dispose:))
		)
	)
)
