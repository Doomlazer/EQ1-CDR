;;; Sierra Script 1.0 - (do not remove this comment)
(script# 59)
(include sci.sh)
(use Main)
(use rm380)
(use n819)
(use RTRandCycle)
(use PolyPath)
(use ForwardCounter)
(use Cycle)
(use Obj)

(public
	delphClickEgo 0
	talk1 1
	talk3 2
)

(local
	[local0 12] = [0 3 3 3 7 1 1 1 2 2 2 2]
	[local12 12] = [7 3 3 3 6 0 4 2 2 2 5 1]
)
(instance talk1 of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 59)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(if (== gSouth 400)
					((ScriptID 2 1) init: 2 0 0 44 1 self)
				else
					((ScriptID 2 1) init: 3 0 0 18 1 self)
				)
			)
			(1 (= seconds (= seconds 2)))
			(2
				(if (== gSouth 400)
					(EcoNarrator posn: 160 20 init: 5 0 0 33 self)
				else
					(EcoNarrator posn: 160 20 init: 6 0 0 20 self)
				)
			)
			(3
				(gLongSong number: 381 play:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance talk3 of Script
	(properties)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 59)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 1) init: 2 0 0 44 1 self)
			)
			(1 (= seconds (= seconds 3)))
			(2
				(EcoNarrator posn: 160 20 init: 5 0 0 33 self)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance delphClickEgo of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== ((ScriptID gNumber 3) view?) 382)
				(== ((ScriptID gNumber 3) loop?) 7)
			)
			(gEgo setLoop: [local12 ((ScriptID gNumber 3) cel?)])
		)
		(if
			(and
				(== ((ScriptID gNumber 3) view?) 394)
				(== ((ScriptID gNumber 3) loop?) 1)
			)
			(gEgo setLoop: [local0 ((ScriptID gNumber 3) cel?)])
		)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 59)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(= global247 7)
				(gEgo setMotion: PolyPath 71 106 self)
			)
			(1
				((ScriptID gNumber 3)
					setMotion: MoveTo (- (gEgo x?) 17) (+ (gEgo y?) 14) self
				)
			)
			(2
				((ScriptID gNumber 3) setHeading: 90 self)
			)
			(3
				((ScriptID gNumber 3) setCycle: 0)
				(= cycles (= cycles 1))
			)
			(4
				((ScriptID gNumber 3)
					view: 382
					loop: 8
					cel: 7
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(5 (= seconds (= seconds 3)))
			(6
				(= global247 8)
				((ScriptID gNumber 3)
					view: 382
					loop: 7
					cel: 9
					posn: (- (gEgo x?) 10) (- (gEgo y?) 5)
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(7
				(gSoundEffects number: 370 loop: -1 flags: 1 play:)
				((ScriptID gNumber 3) setCycle: ForwardCounter 3 self)
			)
			(8
				(EcoNarrator posn: 160 20 init: 5 0 0 42 self)
			)
			(9
				((ScriptID gNumber 3) setCycle: ForwardCounter 3 self)
			)
			(10
				(gSoundEffects stop: flags: 0)
				(gEgo setHeading: 180)
				((ScriptID gNumber 3) hide:)
				(= global247 9)
				((ScriptID 2 1) init: 2 0 0 46 1 self)
			)
			(11
				((ScriptID gNumber 3)
					show:
					posn: (- ((ScriptID gNumber 3) x?) 25) ((ScriptID gNumber 3) y?)
				)
				((ScriptID gNumber 3)
					view: 382
					loop: 8
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(12
				(proc380_5)
				((ScriptID gNumber 3) setMotion: MoveTo 51 139 self)
			)
			(13
				((ScriptID 2 1) init: 2 0 0 55 1 self)
			)
			(14
				((ScriptID gNumber 3) setMotion: MoveTo 51 149 self)
			)
			(15
				(gEgo setLoop: -1)
				(proc819_9 gEgo (ScriptID gNumber 3))
				((ScriptID gNumber 3) setHeading: 0 self)
			)
			(16
				((ScriptID gNumber 3) setCycle: 0)
				(= cycles (= cycles 1))
			)
			(17
				((ScriptID gNumber 3)
					view: 395
					loop: 1
					cel: 0
					posn: 51 159
					cycleSpeed: 3
					setCycle: CT 4 1 self
				)
			)
			(18
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) setCycle: End self)
			)
			(19 (= seconds (= seconds 4)))
			(20
				(gEgo setHeading: 270)
				(gLongSong number: 382 loop: 1 play:)
				((ScriptID gNumber 3)
					view: 394
					loop: 2
					cel: 0
					posn: 17 94
					cycleSpeed: 8
					setCycle: CT 6 1 self
				)
			)
			(21 (= cycles (= cycles 2)))
			(22
				(gLongSong number: 385 loop: 1 play:)
				((ScriptID gNumber 3) setCycle: CT 10 1 self)
			)
			(23
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) cel: 11 setCycle: End self)
			)
			(24
				(gLongSong number: 383 loop: -1 play:)
				((ScriptID 2 1) init: 2 0 0 56 1 self)
			)
			(25
				(= register (= register 3))
				((ScriptID gNumber 3)
					view: 394
					loop: 1
					cel: 8
					posn: 78 106
					setCycle: CT 10 1 self
				)
			)
			(26
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) setCycle: End self)
			)
			(27
				((ScriptID gNumber 3) setPri: 6 setCycle: CT 2 1 self)
			)
			(28
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) setCycle: CT 6 1 self)
			)
			(29
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) setPri: 1 setCycle: CT 7 1 self)
			)
			(30
				((ScriptID gNumber 3) setPri: 6 setCycle: CT 10 1 self)
			)
			(31
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gNumber 3) setCycle: End self)
			)
			(32
				(if (-- register) (= state (= state (- state 6))))
				(if (== register 1)
					((ScriptID 2 1) init: 2 0 0 57 1 self)
				else
					(= ticks (= ticks 3))
				)
			)
			(33
				((ScriptID gNumber 3) hide:)
				(= seconds (= seconds 4))
			)
			(34
				(gEgo setLoop: -1 setMotion: MoveTo 104 105 self)
				((ScriptID gNumber 3)
					show:
					view: 382
					loop: 8
					cel: 0
					posn: 103 139
					setCycle: End
				)
			)
			(35
				((ScriptID 2 1) init: 3 0 0 19 1 self)
			)
			(36
				(gEgo setMotion: MoveTo 114 105 self)
			)
			(37
				(proc819_9 gEgo (ScriptID gNumber 3) self)
			)
			(38
				((ScriptID gNumber 3) setCycle: Beg self)
			)
			(39
				((ScriptID gNumber 3)
					view: 386
					loop: 0
					cel: 0
					posn: 150 107
					setCycle: CT 4 1 self
				)
				(gEgo hide:)
			)
			(40
				(EcoNarrator posn: 160 20 init: 5 0 0 77 self)
			)
			(41
				(= global247 10)
				(gUser canControl: 1 canInput: 1)
				(gIconBar enable: 1)
				(gIconBar enable: 2)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
			)
			(42
				(proc0_4 5 240)
				(proc0_1)
				(= cycles (= cycles 2))
				((ScriptID 2 1) init: 3 0 0 20 1 self)
			)
			(43
				(EcoNarrator posn: 160 20 init: 6 0 0 7 self)
			)
			(44
				(gEgo hide:)
				((ScriptID gNumber 3) setCycle: End self)
			)
			(45
				((ScriptID gNumber 3)
					loop: 3
					cel: 7
					posn: 60 116
					setCycle: End self
				)
			)
			(46
				((ScriptID gNumber 3)
					cel: 0
					setCycle: ForwardCounter 3 self
				)
			)
			(47
				(proc380_8)
				(proc380_5)
				((ScriptID gNumber 3)
					show:
					posn: 42 150
					heading: 315
					loop: 7
				)
				(gEgo show: posn: 42 148 setMotion: PolyPath 74 108 self)
			)
			(48
				((ScriptID gNumber 3) view: 382 loop: 6)
				(proc819_9 gEgo (ScriptID gNumber 3) self)
			)
			(49
				((ScriptID 2 1) init: 2 0 0 48 1 self)
			)
			(50
				(EcoNarrator posn: 160 20 init: 5 0 0 80 self)
			)
			(51
				(proc380_5)
				(= global247 11)
				((ScriptID gNumber 3) setMotion: MoveTo 40 167 self)
			)
			(52
				((ScriptID gNumber 3) setHeading: 90 self)
			)
			(53 (self dispose:))
		)
	)
)
