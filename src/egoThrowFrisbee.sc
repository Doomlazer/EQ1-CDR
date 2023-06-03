;;; Sierra Script 1.0 - (do not remove this comment)
(script# 61)
(include sci.sh)
(use Main)
(use rm380)
(use n819)
(use EcoFeature)
(use PolyPath)
(use n958)
(use Cycle)
(use Obj)

(public
	egoThrowFrisbee 0
	gotIt 1
)

(local
	[local0 16] = [0 3 6 -34 1 3 -8 -34 2 2 17 -31 3 2 -16 -31]
	[local16 8] = [2 5 25 -25 3 5 -25 -25]
	[local24 16] = [7 3 -20 -30 8 3 20 -30 1 2 -3 -7 0 2 3 -7]
	[local40 8] = [3 5 -3 -13 4 5 3 -13]
	local48
	local49
	local50
	local51
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	[local66 26] = [65 126 78 120 99 112 110 116 112 122 101 128 92 136 78 146 70 153 52 159 40 155 48 143 54 134]
)
(procedure (localproc_002c)
	((ScriptID 380 4)
		y: (- ((ScriptID 380 4) y?) 100)
		z: 0
	)
	(cond 
		((proc999_4 0 15 50 100 (ScriptID 380 4)) (= local64 21) (= local65 74))
		((proc999_4 51 8 110 104 (ScriptID 380 4)) (= local64 72) (= local65 67))
		((proc999_4 111 8 160 105 (ScriptID 380 4)) (= local64 132) (= local65 78))
		(else (= local64 193) (= local65 97))
	)
	((ScriptID 380 4)
		y: (+ ((ScriptID 380 4) y?) 100)
		z: 100
	)
)

(procedure (localproc_00f0)
	(if (== ((ScriptID gNumber 3) loop?) 1)
		((ScriptID gNumber 3) cel: 5)
	)
	((ScriptID gNumber 3)
		posn:
			[local66 (* ((ScriptID gNumber 3) cel?) 2)]
			[local66 (+ (* ((ScriptID gNumber 3) cel?) 2) 1)]
	)
)

(instance exchangeFrisbee of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local48 [local40 (= temp0 (* (Random 0 1) 4))])
				(= local60 [local40 (+ temp0 1)])
				(= local52 (+ (gEgo x?) [local40 (+ temp0 2)]))
				(= local53 (+ (gEgo y?) [local40 (+ temp0 3)] 100))
				(= local50 [local24 (= temp0 (* (Random 0 3) 4))])
				(= local61 [local24 (+ temp0 1)])
				(= local54 (+ (gEgo x?) [local24 (+ temp0 2)]))
				(= local55 (+ (gEgo y?) [local24 (+ temp0 3)] 100))
				(= local51
					[local0 (= temp0
						(*
							(+
								(if (> (gEgo x?) ((ScriptID gNumber 3) x?)) 0 else 1)
								(* (Random 0 1) 2)
							)
							4
						)
					)]
				)
				(= local63 [local0 (+ temp0 1)])
				(= local58
					(+ ((ScriptID gNumber 3) x?) [local0 (+ temp0 2)])
				)
				(= local59
					(+ ((ScriptID gNumber 3) y?) [local0 (+ temp0 3)] 100)
				)
				(= local49
					[local16 (= temp0
						(*
							(if (> (gEgo x?) ((ScriptID gNumber 3) x?)) 1 else 0)
							4
						)
					)]
				)
				(= local62 [local16 (+ temp0 1)])
				(= local56
					(+ ((ScriptID gNumber 3) x?) [local16 (+ temp0 2)])
				)
				(= local57
					(+ ((ScriptID gNumber 3) y?) [local16 (+ temp0 3)] 100)
				)
				(proc819_4 112)
				((ScriptID gNumber 3)
					setScript: 0
					setMotion: 0
					view: 390
					setLoop: local51
					cycleSpeed: 10
					cel: 0
				)
				(gEgo view: 383 setLoop: local48 cel: 0 cycleSpeed: 10)
				(gEgo setCycle: CT local60 1 self)
			)
			(1
				((ScriptID 380 4)
					startUpd:
					nsLeft: (- ((ScriptID 380 4) nsLeft?) 5)
					nsRight: (+ ((ScriptID 380 4) nsRight?) 5)
					nsTop: (+ ((ScriptID 380 4) nsTop?) 5)
					nsBottom: (- ((ScriptID 380 4) nsBottom?) 5)
					view: 391
					setLoop: (Random 0 7)
					z: 100
					setPri: 6
					ignoreActors: 1
					cel: 0
					setCycle: Fwd
					posn: local52 local53
					show:
					approachVerbs:
					setMotion: (ScriptID 380 7) local58 local59 self
				)
				(gEgo setCycle: End)
			)
			(2
				(proc819_6 2)
				((ScriptID gNumber 3) cel: 0 setCycle: CT local63 1 self)
			)
			(3
				((ScriptID 380 4) hide: setCycle: 0)
				((ScriptID gNumber 3) setCycle: End self)
			)
			(4
				(if (Random 0 1)
					((ScriptID gNumber 3)
						view: 397
						setLoop: (if (& ((ScriptID gNumber 3) loop?) $0001) 1 else 0)
						cel: 0
					)
					((ScriptID gNumber 3) setCycle:)
				else
					(= register 2)
					(= ticks (++ state))
				)
			)
			(5
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) setCycle: End self)
			)
			(6
				(if (== register 4) ((ScriptID gNumber 3) hide:))
				(= seconds register)
			)
			(7
				((ScriptID gNumber 3)
					show:
					view: 397
					setLoop: local49
					cel: 0
					setCycle: CT local62 1 self
				)
			)
			(8
				(gUser canControl: 1 canInput: 1)
				(gIconBar enable: 2)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				((ScriptID 380 4)
					show:
					setLoop: (Random 0 7)
					posn: local56 local57
					setCycle: Fwd
					setMotion: MoveTo local54 local55 self
				)
				((ScriptID gNumber 3) setCycle: End)
			)
			(9
				(proc0_1)
				(if (proc819_5 112)
					(= global123 0)
					(= global122 0)
					(= global120 0)
					(= global121 0)
					(gEgo
						view: 383
						cycleSpeed: 10
						setLoop: local50
						cel: 0
						setCycle: CT local61 1 self
					)
				else
					(localproc_002c)
					(if (< (gEgo x?) ((ScriptID 380 4) x?))
						(= temp1 -13)
						(= temp2 4)
					else
						(= temp1 25)
						(= temp2 4)
					)
					(= global123 (+ local65 temp2))
					(= global122 (+ local64 temp1))
					(= global120 local64)
					(= global121 (+ local65 100))
					((ScriptID 380 4)
						approachX: (+ local64 temp1)
						approachY: (+ local65 temp2)
						setMotion: MoveTo local64 (+ local65 100) self
					)
				)
				(proc0_1)
			)
			(10
				(proc0_1)
				(if (proc819_5 112)
					(gEgo get: 15 setCycle: End self)
					((ScriptID 380 4) setCycle: 0 hide:)
				else
					(gSoundEffects number: 390 loop: 1 play:)
					((ScriptID 380 4)
						view: 380
						loop: 5
						cel: 0
						setPri: 1
						setCycle: 0
					)
					(= cycles 1)
				)
			)
			(11
				((ScriptID 380 4) stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance egoThrowFrisbee of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 61)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 15 380)
				(proc0_1)
				(gIconBar disable: 7)
				((ScriptID gNumber 3) setScript: 0)
				(proc958_0 128 383 397 390 391)
				(if (> (gEgo x?) 228)
					(gEgo setMotion: PolyPath 139 82 self)
				else
					(= cycles 1)
				)
			)
			(1
				(proc819_3 111)
				(if (and (<= 11 global247) (<= global247 14))
					(if (== ((ScriptID gNumber 3) loop?) 1)
						((ScriptID gNumber 3) loop: 0 cel: 5)
					)
					(= global248 ((ScriptID gNumber 3) cel?))
					(localproc_00f0)
					((ScriptID gNumber 3)
						view: 390
						z: 0
						cel: 0
						setCycle: 0
						setMotion: 0
						setScript: 0
					)
					(= ticks 1)
				else
					((ScriptID 2 0) init: 1 0 0 31 1)
					((ScriptID gNumber 3)
						setCycle: 0
						setScript: 0
						setMotion: MoveTo 94 109 self
					)
				)
				(++ global247)
			)
			(2
				(switch global247
					(12 (proc0_4 1 231))
					(13 (proc0_4 1 232))
					(14 (proc0_4 1 233))
					(16 (proc0_4 1 234))
					(17 (proc0_4 1 235))
				)
				(self setScript: exchangeFrisbee self)
			)
			(3
				(proc819_6 2)
				(if (<= global247 14)
					((ScriptID gNumber 3)
						setLoop: 0
						setScript: (ScriptID 380 11)
					)
				else
					(proc380_5)
					((ScriptID 380 6) seconds: 0)
					((ScriptID gNumber 3) setScript: (ScriptID 380 6))
				)
				(= seconds 2)
			)
			(4
				(if
					(and
						(== client global2)
						(!= ((ScriptID gNumber 3) script?) (ScriptID 380 6))
					)
					(proc0_2)
					(gIconBar enable: 7)
				)
				(proc819_4 111)
				(self dispose:)
			)
		)
	)
)

(instance gotIt of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 61)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gIconBar disable: 7)
				(proc0_4 1 234)
				(proc958_0 128 396 383 397 390 391 386 385)
				((ScriptID gNumber 3) setScript: 0 setCycle: Fwd)
				(gEgo setMotion: PolyPath 29 76 self)
			)
			(1
				(localproc_00f0)
				(proc380_5)
				((ScriptID gNumber 3)
					setPri: 6
					setMotion: MoveTo 81 152 self
				)
			)
			(2
				((ScriptID gNumber 3) setHeading: 90 self)
			)
			(3
				((ScriptID gNumber 3) setCycle: 0)
				(gEgo view: 383 loop: 4 cel: 0 setCycle: CT 5 1 self)
			)
			(4
				(gEgo setCycle: End)
				((ScriptID 380 4)
					startUpd:
					show:
					z: 0
					setPri: 15
					view: 391
					setLoop: 5
					setCycle: Fwd
					posn: 31 62
					setMotion: (ScriptID 380 7) 109 109 self
				)
			)
			(5
				((ScriptID 380 4) setCycle: 0)
				(gLongSong number: 382 loop: 1 play:)
				((ScriptID gNumber 3)
					view: 395
					loop: 3
					cel: 0
					cycleSpeed: 10
					setCycle: CT 3 1 self
				)
			)
			(6
				((ScriptID 2 0) init: 1 0 0 1 1 self)
				(= ticks 1)
			)
			(7
				((ScriptID 380 1)
					view: 381
					loop: 7
					cel: 0
					setPri: 15
					posn: 29 44
					init:
				)
				(gLongSong number: 384 loop: -1 play:)
				((ScriptID 380 4) hide: setCycle: 0)
				((ScriptID gNumber 3) setCycle: CT 7 1 self)
			)
			(8
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) setCycle: End self)
			)
			(9 (proc819_6 4) (= seconds 3))
			(10
				(UnLoad 128 395)
				((ScriptID 380 1) dispose:)
				(gEgo view: 383 loop: 6 cel: 0)
				((ScriptID gNumber 3)
					view: 397
					loop: 3
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(11
				((ScriptID 380 4)
					startUpd:
					show:
					posn: 63 129
					setCycle: Fwd
					setPri: 15
					setMotion: MoveTo 76 56 self
				)
			)
			(12
				(gEgo
					cycleSpeed: (+ (gEgo cycleSpeed?) 7)
					setCycle: CT 3 1 self
				)
			)
			(13
				((ScriptID 380 4) hide: setCycle: 0 setPri: -1)
				(gEgo setCycle: CT 7 1 self)
			)
			(14
				((ScriptID 380 4) stopUpd:)
				(gSoundEffects number: 398 loop: 1 play:)
				(gEgo setPri: -1 setCycle: End self)
			)
			(15
				(proc380_8)
				(gEgo hide: posn: 71 101 get: 15)
				(proc819_3 113)
				(proc380_5)
				((ScriptID gNumber 3)
					ignoreActors: 1
					setMotion: MoveTo 95 102 self
				)
			)
			(16
				(gEgo show:)
				(proc819_9 gEgo (ScriptID gNumber 3))
				(proc819_9 (ScriptID gNumber 3) gEgo self)
			)
			(17
				((ScriptID gNumber 3) setCycle: 0)
				(= cycles 1)
			)
			(18
				(gEgo hide:)
				(gEgo put: 15 360)
				((ScriptID gNumber 3)
					view: 385
					loop: 3
					cel: 0
					posn: 94 102
				)
				((ScriptID 380 4) dispose:)
				(UnLoad 128 383)
				(UnLoad 128 397)
				(= seconds 3)
			)
			(19
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(20
				((ScriptID 2 0) init: 1 0 0 2 1 self)
			)
			(21
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(22
				((ScriptID 2 0) init: 1 0 0 3 0 self)
			)
			(23
				((ScriptID 2 0) init: 1 0 0 4 1 self)
			)
			(24
				((ScriptID 2 1) init: 2 0 0 3 1 self)
			)
			(25
				((ScriptID 2 0) init: 1 0 0 5 1 self)
			)
			(26
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(27
				((ScriptID 2 0) init: 1 0 0 6 0 self)
			)
			(28
				((ScriptID 2 0) init: 1 0 0 7 0 self)
			)
			(29
				((ScriptID 2 0) init: 1 0 0 8 1 self)
			)
			(30
				((ScriptID 2 1) init: 2 0 0 5 1 self)
			)
			(31
				((ScriptID 2 0) init: 1 0 0 9 1 self)
			)
			(32
				((ScriptID 2 1) init: 2 0 0 6 1 self)
			)
			(33
				((ScriptID 2 0) init: 1 0 0 10 1 self)
			)
			(34
				((ScriptID 2 1) init: 2 0 0 7 1 self)
			)
			(35
				((ScriptID 2 0) init: 1 0 0 11 0 self)
			)
			(36
				((ScriptID 2 0) init: 1 0 0 12 0 self)
			)
			(37
				((ScriptID 2 0) init: 1 0 0 13 1 self)
			)
			(38
				((ScriptID gNumber 3) cycleSpeed: 25 setCycle: End self)
			)
			(39
				((ScriptID 2 1) init: 3 0 0 14 1 self)
			)
			(40
				(hugBackDrop init:)
				(egoEyes init:)
				(delphEyes init:)
				(= seconds 4)
			)
			(41
				(egoEyes setCycle: End self)
				(= seconds 4)
			)
			(42
				(delphEyes setCycle: End)
				(= seconds 4)
			)
			(43
				(hugBackDrop dispose:)
				(egoEyes dispose:)
				(delphEyes dispose:)
				(UnLoad 128 385)
				(= cycles 1)
			)
			(44
				((ScriptID gNumber 3) cycleSpeed: 25 setCycle: Beg self)
			)
			(45
				(proc380_5)
				((ScriptID gNumber 3) loop: 1)
				(gEgo show:)
				(= seconds 2)
			)
			(46
				(gEgo setMotion: PolyPath 69 100 self)
			)
			(47
				(gEgo
					view: 381
					loop: 0
					cel: 12
					posn: 84 83
					setPri: -1
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(48
				(proc819_6 6)
				(proc819_4 113)
				(gEgo setMotion: MoveTo 94 73 self)
			)
			(49
				(proc0_2)
				((ScriptID gNumber 3) setScript: (ScriptID 380 6))
				(UnLoad 128 381 385)
				(= global247 15)
				(gIconBar enable: 7)
				(self dispose:)
			)
		)
	)
)

(instance hugBackDrop of EcoView
	(properties
		x 72
		y 109
		view 385
		priority 13
		signal $4010
	)
)

(instance egoEyes of EcoProp
	(properties
		x 52
		y 67
		view 385
		loop 1
		priority 14
		signal $4010
	)
)

(instance delphEyes of EcoProp
	(properties
		x 80
		y 65
		view 385
		loop 2
		priority 14
		signal $4010
	)
)
