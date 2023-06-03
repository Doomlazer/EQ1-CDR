;;; Sierra Script 1.0 - (do not remove this comment)
(script# 123)
(include sci.sh)
(use Main)
(use regionFish)
(use Smopper)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use DPath)
(use Grooper)
(use Sound)
(use Cycle)
(use Obj)

(public
	fleshEater 0
)

(local
	local0
	local1
	local2
)
(procedure (localproc_0779)
	(delphi
		view: 831
		z: 100
		setLoop: -1
		setLoop: delphStopGroop
		setPri: -1
		setMotion: 0
		illegalBits: 0
		ignoreActors: 1
		ignoreHorizon: 1
		setStep: 12 7
		moveSpeed: 8
		cycleSpeed: 10
		setCycle: Smopper 836 0 0 20
	)
)

(instance fleshEater of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (and local2 local1)
			(= local1 0)
			(= local2 0)
			(= cycles 1)
		)
	)
	
	(method (dispose)
		(delphi
			setMotion: 0
			setCycle: 0
			setLoop: 0
			dispose:
			delete:
		)
		(fishSound dispose:)
		(super dispose:)
		(DisposeScript 123)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gLongSong number: 121 loop: -1 play:)
				(gEgo
					setCycle: 0
					view: 809
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(1
				(proc819_6)
				(gEgo setMotion: MoveTo 175 62 self)
			)
			(2 (gEgo setHeading: 270 self))
			(3
				(gCast eachElementDo: #perform getRidOfFish)
				(gEgo setCycle: 0 view: 121 loop: 1 cel: 0 posn: 171 68)
				(fish1 init: setCycle: Fwd setMotion: MoveTo 74 74 self)
				(fishSound number: 126 loop: 1 play:)
			)
			(4
				(fish2 init: setCycle: End fish2)
				(fish1 setLoop: 1 cel: 0 setCycle: End)
			)
			(5
				(EcoNarrator posn: 45 142 init: 3 0 0 55 self)
			)
			(6
				(scaredInset init:)
				(egoScared init:)
				(= cycles 1)
			)
			(7
				(if (< (= local0 (+ local0 1)) 10)
					(-- state)
					(egoScared cel: local0)
					(Palette palSET_INTENSITY 0 255 (- 100 (* local0 2)))
				)
				(= cycles 2)
			)
			(8
				(EcoNarrator posn: 45 142 init: 3 0 0 18 self)
			)
			(9 (= seconds 3))
			(10
				(EcoNarrator posn: 45 142 init: 3 0 0 19 self)
			)
			(11
				(scaredInset dispose:)
				(egoScared dispose:)
				(fish1 dispose:)
				(= seconds 2)
			)
			(12
				(gSoundEffects number: 920 loop: 1 play:)
				(delphi init: setPri: 7 setCycle: CT 6 1 self)
			)
			(13
				(delphi cel: 7 ignoreActors: setCycle: End delphi)
				(gEgo
					cycleSpeed: (delphi cycleSpeed?)
					setCycle: End self
				)
			)
			(14
				(gSoundEffects number: 122 loop: 1 play:)
				(gLongSong2 number: 208 loop: 1 play:)
				(gEgo
					view: 121
					setLoop: 2
					cel: 2
					setCycle: Fwd
					cycleSpeed: 0
					setMotion: MoveTo 213 128 self
				)
			)
			(15
				(gEgo
					setPri: 13
					setCycle: CT 0 1
					setMotion: MoveTo 248 199 self
				)
			)
			(16
				(gLongSong2 number: 127 loop: 1 play:)
				(gEgo
					view: 805
					loop: 2
					cel: 0
					posn: 237 207
					setMotion: MoveTo 237 193 self
				)
			)
			(17
				(gEgo setSpeed: 6)
				(= cycles 20)
			)
			(18
				(if (< (= local0 (+ local0 1)) 50)
					(-- state)
					(Palette palSET_INTENSITY 0 255 (- 100 (* local0 2)))
				)
				(= cycles 2)
			)
			(19 (= seconds 2))
			(20
				(if (>= (= local0 (- local0 4)) 10)
					(-- state)
					(Palette palSET_INTENSITY 0 255 (- 100 (* local0 2)))
				)
				(= cycles 4)
			)
			(21
				(EcoNarrator posn: 45 142 init: 3 0 0 20 self)
			)
			(22
				(gLongSong fade:)
				(manta init:)
				(= cycles 1)
			)
			(23
				(if (>= (= local0 (- local0 1)) 0)
					(-- state)
					(Palette palSET_INTENSITY 0 255 (- 100 (* local0 2)))
				)
				(= cycles 4)
			)
			(24 (= local2 1))
			(25
				(gEgo
					view: 802
					setLoop: 3
					cel: 0
					setCycle: 0
					posn: 230 189
					setMotion: MoveTo 230 155 self
				)
			)
			(26
				(gEgo
					setCycle: Walk
					setLoop: -1
					setLoop: gStopGroop
					setMotion: DPath 230 138 181 111 self
				)
			)
			(27
				(proc819_6 3)
				(gEgo ignoreHorizon: setPri: 7)
				(localproc_0779)
				(delphi
					setPri: 7
					posn: -16 123 0
					heading: 90
					loop: 0
					setMotion: MoveTo 86 75 self
				)
			)
			(28
				(proc819_9 delphi gEgo self)
				(proc819_9 gEgo delphi)
			)
			(29 (= cycles 7))
			(30
				((ScriptID 2 0) init: 1 0 0 6 1 self)
			)
			(31
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(32
				((ScriptID 2 0) init: 1 0 0 7 1 self)
			)
			(33
				((ScriptID 2 0) init: 1 0 0 8 1 self)
			)
			(34
				((ScriptID 2 1) init: 2 0 0 5 1 self)
			)
			(35
				((ScriptID 2 0) init: 1 0 0 9 1 self)
			)
			(36
				((ScriptID 2 0) init: 1 0 0 10 1 self)
			)
			(37
				(delphi
					setCycle: 0
					view: 834
					loop: 1
					cel: 0
					posn: 121 71
					setCycle: End self
				)
			)
			(38
				(delphi dispose:)
				(= cycles 2)
			)
			(39
				(proc0_2)
				(gCast eachElementDo: #perform startFish)
				(self dispose:)
			)
		)
	)
)

(instance scaredInset of EcoView
	(properties
		x 167
		y 80
		view 150
		priority 14
		signal $0011
	)
)

(instance egoScared of EcoProp
	(properties
		x 167
		y 80
		view 150
		loop 1
		priority 15
		signal $4010
	)
)

(instance fish1 of EcoActor
	(properties
		y 100
		view 124
		moveSpeed 2
	)
)

(instance fish2 of EcoActor
	(properties
		x 263
		y 67
		view 124
		loop 2
		signal $4000
	)
	
	(method (cue)
		(if (< loop 4)
			(= loop (+ loop 1))
			(= cel 0)
			(self setCycle: End self)
		else
			(fleshEater cue:)
			(self dispose: delete:)
		)
	)
)

(instance delphi of EcoActor
	(properties
		x 136
		y 41
		view 121
		signal $4000
	)
	
	(method (cue)
		(self
			view: 831
			posn: 142 68
			setLoop: 5
			cel: 0
			setStep: 8 4
			moveSpeed: 0
			setCycle: Walk
			setMotion: MoveTo 0 140
		)
	)
)

(instance manta of EcoActor
	(properties
		x 116
		y -4
		view 604
		signal $6010
		cycleSpeed 8
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: End self)
	)
	
	(method (cue)
		(if (not (& signal skipCheck))
			(self
				signal: (| signal skipCheck)
				setMotion: MoveTo 124 23 self
			)
		else
			(= local1 1)
			(self setCycle: 0 dispose: delete:)
		)
	)
)

(instance delphStopGroop of Grooper
	(properties)
)

(instance getRidOfFish of Code
	(properties)
	
	(method (doit param1)
		(if (param1 isKindOf: Fish)
			(param1 setMotion: 0 setStep: 14 4)
			(if (>= (param1 x?) 160)
				(param1
					setLoop: (+ (* (param1 fishNumber?) 2) 1)
					setMotion: MoveTo -30 (param1 y?)
				)
			else
				(param1
					setLoop: (* (param1 fishNumber?) 2)
					setMotion: MoveTo 350 (param1 y?)
				)
			)
		)
	)
)

(instance startFish of Code
	(properties)
	
	(method (doit param1)
		(if (param1 isKindOf: Fish)
			(param1 setStep: 3 2 startMove:)
		)
	)
)

(instance fishSound of Sound
	(properties)
)
