;;; Sierra Script 1.0 - (do not remove this comment)
(script# 101)
(include sci.sh)
(use Main)
(use EcoRoom)
(use EcoFeature)
(use RTRandCycle)
(use Osc)
(use n958)
(use Cycle)
(use Obj)

(public
	rm101 0
)

(local
	local0 =  1
	[local1 500]
)
(procedure (localproc_00e4 param1)
	(EcoNarrator init: 2 0 0 param1 self)
)

(procedure (localproc_00f4 param1 param2 param3 &tmp temp0)
	(= temp0 param2)
	(while (>= temp0 param3)
		(Palette palSET_INTENSITY 33 255 temp0)
		(Wait param1)
		(= temp0 (- temp0 5))
	)
)

(instance rm101 of EcoRoom
	(properties
		picture 100
		style $000a
		horizon 15
		lookStr 37
	)
	
	(method (init)
		(= global250 1)
		(= global251 1)
		(whale init:)
		(gEgo
			init:
			view: 850
			setLoop: 1
			setCel: 0
			posn: 15 48
			setPri: 10
			signal: 16400
		)
		(proc958_0
			128
			100
			850
			851
			852
			853
			660
			662
			957
			107
			242
			157
			236
			234
			235
			249
			166
			185
			106
		)
		(proc958_0 129 660 340)
		(proc958_0 132 666 381 646)
		(plant setCycle: Fwd init:)
		(leaves setCycle: Fwd init:)
		(super init:)
		(gLongSong number: 666 loop: -1 play:)
		(proc0_1)
		(SetCursor 957 0 9)
		(self setScript: cetusRide)
	)
	
	(method (doit)
		(SetCursor 0 200)
		(SetCursor 957 0 9)
		(super doit: &rest)
	)
)

(instance cetusRide of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(if (== (gLongSong prevSignal?) 10)
					(= cycles (= cycles 1))
				else
					(-- state)
					(= cycles (= cycles 1))
				)
			)
			(1
				(whale setMotion: MoveTo 70 79 self)
			)
			(2
				(EcoNarrator posn: -1 16 init: 1 0 0 1 self)
			)
			(3
				(whale setMotion: MoveTo 140 79 self)
			)
			(4
				(EcoNarrator posn: -1 16 init: 1 0 0 2 self)
			)
			(5
				(gSoundEffects number: 646 play:)
				(whale setMotion: MoveTo 213 79 self)
			)
			(6
				(localproc_00e4 1)
				(= cycles (= cycles 1))
			)
			(7
				(= local0 0)
				(= ticks (= ticks 120))
			)
			(8
				(EcoNarrator posn: -1 16 init: 1 0 0 3 self)
			)
			(9
				(gEgo
					setLoop: 2
					setCel: 0
					posn: 144 63
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(10
				(gEgo setScript: adamSwim)
				(fish1 init: setCycle: Fwd setMotion: MoveTo 114 129 self)
				(fish2 init: setCycle: Fwd setMotion: MoveTo 230 127 self)
			)
			(11 0)
			(12
				(fish1
					setLoop: 3
					setCel: 0
					posn: 136 124
					cycleSpeed: 18
					setCycle: End
				)
				(fish2
					setLoop: 2
					setCel: 0
					posn: 206 124
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(13
				(gCast eachElementDo: #hide)
				(global2 drawPic: 901 9)
				(= seconds (= seconds 2))
			)
			(14
				(global2 drawPic: 660 9 setScript: conchCeremony)
				(self dispose:)
			)
		)
	)
)

(instance adamSwim of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo
					setLoop: 3
					setCel: 0
					posn: 187 100
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 4
					setCel: 0
					posn: 170 121
					cycleSpeed: 3
					setCycle: Fwd
				)
				(= cycles (= cycles 1))
			)
			(2 (self dispose:))
		)
	)
)

(instance conchCeremony of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo
					show:
					view: 660
					setLoop: 6
					setCel: 0
					posn: 162 89
					cycleSpeed: 12
				)
				(epiderm init: setCycle: Fwd)
				(hippo init: setCycle: Fwd)
				(olympia init: setCycle: Fwd)
				(erron init: setCycle: Fwd)
				(narc init: setCycle: Fwd)
				(delph init: setCycle: Fwd)
				(greg init: setCycle: Fwd)
				(superf init: setCycle: Fwd)
				(lobster init: setCycle: Fwd)
				(oracle init: setCycle: Fwd)
				(= ticks (= ticks 360))
			)
			(1
				(Superfluous init: 3 0 0 1 1 self)
			)
			(2 (= cycles (= cycles 1)))
			(3 (= ticks (= ticks 120)))
			(4 (= cycles (= cycles 1)))
			(5
				(Hippocrates init: 4 0 0 1 1 self)
			)
			(6 (= ticks (= ticks 120)))
			(7 (= cycles (= cycles 1)))
			(8
				(Epidermis init: 5 0 0 1 1 self)
			)
			(9 (= ticks (= ticks 120)))
			(10 (= cycles (= cycles 1)))
			(11
				(Demeter init: 6 0 0 1 1 self)
			)
			(12 (= ticks (= ticks 120)))
			(13 (= cycles (= cycles 1)))
			(14
				(Erroneous init: 7 0 0 1 1 self)
			)
			(15 (= ticks (= ticks 120)))
			(16 (= cycles (= cycles 1)))
			(17
				(Gregarious init: 8 0 0 1 1 self)
			)
			(18 (= ticks (= ticks 120)))
			(19 (= cycles (= cycles 1)))
			(20
				(Narcissus init: 9 0 0 1 1 self)
			)
			(21 (= ticks (= ticks 120)))
			(22 (= cycles (= cycles 1)))
			(23
				(Olympia init: 10 0 0 1 1 self)
			)
			(24 (= ticks (= ticks 120)))
			(25 (= cycles (= cycles 1)))
			(26
				(Oracle init: 11 0 0 1 1 self)
			)
			(27 (= ticks (= ticks 120)))
			(28 (= cycles (= cycles 1)))
			(29
				(localproc_00e4 2)
				(= cycles (= cycles 1))
			)
			(30 (= ticks (= ticks 120)))
			(31 (= cycles (= cycles 1)))
			(32
				(localproc_00e4 3)
				(= cycles (= cycles 1))
			)
			(33 (= ticks (= ticks 120)))
			(34 (= cycles (= cycles 1)))
			(35
				(localproc_00e4 4)
				(= cycles (= cycles 1))
			)
			(36 (= ticks (= ticks 120)))
			(37 (= cycles (= cycles 1)))
			(38
				(localproc_00e4 5)
				(= cycles (= cycles 1))
			)
			(39 (= ticks (= ticks 120)))
			(40 (= cycles (= cycles 1)))
			(41
				((ScriptID 2 1) init: 12 0 0 1 1 self)
			)
			(42
				(cushionFish
					init:
					setLoop: 7
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 132 97 self
				)
				(conch
					init:
					setLoop: 8
					setCel: 0
					setMotion: MoveTo 166 88 self
				)
			)
			(43 0)
			(44
				(localproc_00e4 6)
				(= cycles (= cycles 1))
			)
			(45 (= cycles (= cycles 1)))
			(46
				(cushionFish setMotion: MoveTo 152 97 self)
				(conch setMotion: MoveTo 186 88 self)
			)
			(47 0)
			(48 (= ticks (= ticks 60)))
			(49
				(gEgo
					view: 660
					setLoop: 7
					setCel: 0
					posn: 165 95
					setCycle: CT 5 1 self
				)
			)
			(50
				(proc0_4 20 251)
				(conch hide:)
				(gEgo setCycle: End self)
			)
			(51
				(gEgo view: 853 setLoop: 12 setCel: 0 setCycle: Fwd)
				(= ticks (= ticks 60))
			)
			(52
				(gEgo setLoop: 13 setCel: 0 setCycle: CT 5 1 self)
			)
			(53
				(gSoundEffects number: 646 play:)
				(gEgo setCycle: CT 8 1)
				(= ticks (= ticks 90))
			)
			(54 (gEgo setCycle: End self))
			(55
				(gEgo setLoop: 14 setCel: 0 setCycle: Fwd)
				(= ticks (= ticks 120))
			)
			(56
				((ScriptID 2 1) init: 12 0 0 2 1 self)
			)
			(57 (= ticks (= ticks 180)))
			(58
				(cushionFish setMotion: MoveTo 350 97)
				(localproc_00e4 7)
				(= cycles (= cycles 1))
			)
			(59 (= ticks (= ticks 120)))
			(60
				((ScriptID 2 0) init: 13 0 0 1 1 self)
			)
			(61
				(gLongSong fade: 0 10 2 1)
				(= cycles (= cycles 1))
			)
			(62
				(if (> (cushionFish x?) 349)
					(= cycles (= cycles 1))
				else
					(-- state)
					(= cycles (= cycles 1))
				)
			)
			(63
				(= ticks (= ticks 20))
				(gCast eachElementDo: #hide)
				(global2 drawPic: 901 -32759)
			)
			(64
				(global2 drawPic: 340 -32759 setScript: delphDialog)
				(self dispose:)
			)
		)
	)
)

(instance delphDialog of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gLongSong number: 381 loop: -1 play:)
				(= cycles (= cycles 2))
			)
			(1
				(EcoNarrator init: 1 0 0 4 self)
			)
			(2
				(localproc_00f4 5 100 90)
				(gEgo
					show:
					view: 106
					setLoop: 0
					setCel: 0
					posn: -20 100
					setStep: 7 4
					cycleSpeed: 5
					moveSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo 80 100 self
				)
			)
			(3
				(gEgo setMotion: MoveTo 370 100 self)
				((ScriptID 2 1) init: 12 0 0 3 1 self)
			)
			(4 0)
			(5
				(localproc_00f4 5 90 80)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(6
				(gEgo setMotion: MoveTo 370 100 self)
				((ScriptID 2 0) init: 13 0 0 2 1 self)
			)
			(7 0)
			(8
				(localproc_00f4 5 80 70)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(9
				(gEgo setMotion: MoveTo 370 100 self)
				((ScriptID 2 1) init: 12 0 0 4 1 self)
			)
			(10 0)
			(11
				(localproc_00f4 5 70 60)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(12
				(gEgo setScript: adamDelSwim)
				((ScriptID 2 0) init: 13 0 0 3 1 self)
			)
			(13
				(localproc_00f4 5 50 40)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(14
				(gEgo setMotion: MoveTo 370 100 self)
				((ScriptID 2 1) init: 12 0 0 5 1 self)
			)
			(15 0)
			(16
				(localproc_00f4 5 40 30)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(17
				(gEgo setMotion: MoveTo 370 100 self)
				((ScriptID 2 0) init: 13 0 0 4 1 self)
			)
			(18 0)
			(19
				(localproc_00f4 5 30 0)
				(= cycles (= cycles 1))
			)
			(20 (= ticks (= ticks 60)))
			(21
				(global2 newRoom: 680)
				(self dispose:)
			)
		)
	)
)

(instance adamDelSwim of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setMotion: MoveTo 370 100 self)
			)
			(1
				(localproc_00f4 5 60 50)
				(gEgo posn: -20 100 setMotion: MoveTo 370 100 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance leaves of EcoProp
	(properties
		x 281
		y 100
		view 100
		loop 1
		priority 10
		signal $4010
		cycleSpeed 12
		detailLevel 2
		lookStr 8
	)
)

(instance plant of EcoProp
	(properties
		x 258
		y 5
		view 100
		loop 2
		signal $4010
		cycleSpeed 12
		detailLevel 2
		lookStr 8
	)
)

(instance whale of EcoActor
	(properties
		x -25
		y 50
		view 850
	)
	
	(method (doit)
		(super doit: &rest)
		(if local0
			(gEgo posn: (+ (whale x?) 15) (- (whale y?) 2))
		)
	)
)

(instance eye1 of EcoActor
	(properties
		x 139
		y 63
		view 660
		loop 2
		cel 1
	)
)

(instance fin of EcoActor
	(properties
		x 18
		y 70
		view 660
		loop 3
		cel 1
	)
)

(instance eye3 of EcoActor
	(properties
		x 129
		y 71
		view 662
		loop 1
		signal $4000
	)
)

(instance eye4 of EcoActor
	(properties
		x 129
		y 71
		view 662
		loop 2
		signal $4000
	)
)

(instance eye2 of EcoActor
	(properties
		x 129
		y 71
		view 662
	)
)

(instance eye5 of EcoActor
	(properties
		x 129
		y 71
		view 662
		loop 3
		signal $4000
	)
)

(instance eye6 of EcoActor
	(properties
		x 129
		y 71
		view 662
		loop 4
		signal $4000
	)
)

(instance brow of EcoActor
	(properties
		x 119
		y 73
		view 662
		loop 5
	)
)

(instance epiderm of EcoProp
	(properties
		x 72
		y 121
		view 853
		loop 1
		cel 2
	)
)

(instance hippo of EcoProp
	(properties
		x 273
		y 96
		view 853
		loop 5
		cycleSpeed 12
	)
)

(instance olympia of EcoProp
	(properties
		x 96
		y 150
		view 853
		loop 2
		cel 1
		cycleSpeed 12
	)
)

(instance erron of EcoProp
	(properties
		x 69
		y 61
		view 853
		cycleSpeed 18
	)
)

(instance narc of EcoProp
	(properties
		x 251
		y 57
		view 853
		loop 6
		cel 1
		cycleSpeed 12
	)
)

(instance delph of EcoProp
	(properties
		x 254
		y 138
		view 853
		loop 4
		cel 5
		cycleSpeed 12
	)
)

(instance greg of EcoProp
	(properties
		x 172
		y 163
		view 853
		loop 3
		cel 1
		cycleSpeed 12
	)
)

(instance egogetshell of EcoActor
	(properties
		x 163
		y 94
		view 853
		loop 10
		cel 8
		signal $4000
	)
)

(instance superf of EcoProp
	(properties
		x 216
		y 26
		view 162
		loop 1
		cel 2
		cycleSpeed 12
	)
)

(instance lobster of EcoProp
	(properties
		x 97
		y 37
		view 341
		loop 4
		cel 3
		cycleSpeed 12
	)
)

(instance oracle of EcoProp
	(properties
		x 154
		y 26
		view 853
		loop 11
		cel 5
	)
)

(instance fish1 of EcoActor
	(properties
		y 189
		view 851
	)
)

(instance fish1b of EcoActor
	(properties
		x 133
		y 147
		view 851
	)
)

(instance fish2 of EcoActor
	(properties
		x 317
		y 116
		view 851
		loop 4
	)
)

(instance fish2a of EcoActor
	(properties
		x 218
		y 131
		view 851
		loop 4
	)
)

(instance cushionFish of EcoActor
	(properties
		x -10
		y 103
		view 853
		loop 7
		signal $4010
	)
)

(instance conch of EcoActor
	(properties
		x 24
		y 95
		view 853
		loop 8
		priority 7
		signal $0010
	)
)

(instance cushionFishB of EcoActor
	(properties
		x 152
		y 97
		view 853
		loop 7
		signal $4000
	)
)

(instance conchB of EcoActor
	(properties
		x 186
		y 88
		view 853
		loop 8
		priority 7
		signal $4010
	)
)

(instance Narcissus of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 236
		viewInPrint 1
		charNum 11
		keepWindow 1
	)
	
	(method (init)
		(super init: nBust nEyes nMouth &rest)
	)
)

(instance nBust of EcoProp
	(properties
		view 236
		cel 1
	)
)

(instance nEyes of EcoProp
	(properties
		nsTop 7
		nsLeft 16
		view 236
		loop 2
		cycleSpeed 30
	)
)

(instance nMouth of EcoProp
	(properties
		nsTop 15
		nsLeft 17
		view 236
		loop 1
		cycleSpeed 10
	)
)

(instance Epidermis of EcoTalker
	(properties
		nsTop 105
		nsLeft 5
		view 234
		viewInPrint 1
		charNum 10
		keepWindow 1
	)
	
	(method (init)
		(super init: eBust eEyes eMouth &rest)
	)
)

(instance eBust of EcoProp
	(properties
		view 234
		cel 1
	)
)

(instance eEyes of EcoProp
	(properties
		nsTop 18
		nsLeft 33
		view 234
		loop 2
		cycleSpeed 30
	)
)

(instance eMouth of EcoProp
	(properties
		nsTop 23
		nsLeft 30
		view 234
		loop 1
		cycleSpeed 10
	)
)

(instance Hippocrates of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 235
		viewInPrint 1
		charNum 12
		keepWindow 1
	)
	
	(method (init)
		(super init: hBust hEyes hMouth &rest)
	)
)

(instance hBust of EcoProp
	(properties
		view 235
		cel 1
	)
)

(instance hEyes of EcoProp
	(properties
		nsTop 5
		nsLeft 20
		view 235
		loop 3
		cycleSpeed 30
	)
)

(instance hMouth of EcoProp
	(properties
		nsTop 10
		nsLeft 19
		view 235
		loop 1
		cycleSpeed 10
	)
)

(instance Erroneous of EcoTalker
	(properties
		nsTop 105
		nsLeft 5
		view 239
		viewInPrint 1
		charNum 13
		keepWindow 1
	)
	
	(method (init)
		(super init: erBust erEyes erMouth &rest)
	)
)

(instance erBust of EcoProp
	(properties
		view 107
		cel 1
	)
)

(instance erEyes of EcoProp
	(properties
		nsTop 16
		nsLeft 10
		view 107
		loop 2
		cycleSpeed 30
	)
)

(instance erMouth of EcoProp
	(properties
		nsTop 19
		nsLeft 4
		view 107
		loop 1
		cycleSpeed 10
	)
)

(instance Gregarious of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 249
		viewInPrint 1
		charNum 7
		keepWindow 1
	)
	
	(method (init)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of EcoProp
	(properties
		view 249
	)
)

(instance gEyes of EcoProp
	(properties
		nsTop 13
		nsLeft 13
		view 249
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of EcoProp
	(properties
		nsTop 16
		nsLeft 9
		view 249
		loop 1
		cycleSpeed 10
	)
)

(instance Superfluous of EcoTalker
	(properties
		nsTop 105
		nsLeft 5
		view 166
		viewInPrint 1
		charNum 5
		keepWindow 1
	)
	
	(method (init)
		(super init: sBust sEyes sMouth &rest)
	)
)

(instance sBust of EcoProp
	(properties
		view 166
		cel 1
	)
)

(instance sEyes of EcoProp
	(properties
		nsTop 6
		nsLeft 4
		view 166
		loop 2
		cycleSpeed 30
	)
)

(instance sMouth of EcoProp
	(properties
		view 166
		loop 1
		cycleSpeed 10
	)
)

(instance Demeter of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 185
		loop 3
		viewInPrint 1
		charNum 18
		keepWindow 1
	)
	
	(method (init)
		(super init: demBust demEyes demMouth &rest)
	)
)

(instance demBust of EcoProp
	(properties
		view 185
	)
)

(instance demEyes of EcoProp
	(properties
		nsTop 16
		nsLeft 13
		view 185
		loop 2
		cycleSpeed 30
	)
)

(instance demMouth of EcoProp
	(properties
		nsTop 21
		nsLeft 16
		view 185
		loop 1
		cycleSpeed 10
	)
)

(instance conchTreading of Osc
	(properties)
	
	(method (doit &tmp oscNextCel)
		(if
			(or
				(> (= oscNextCel (self nextCel:)) 10)
				(< oscNextCel 5)
			)
			(= cycleDir (= cycleDir (- cycleDir)))
			(self cycleDone:)
		else
			(client cel: oscNextCel)
		)
	)
)

(instance Olympia of EcoTalker
	(properties
		nsTop 105
		nsLeft 5
		view 242
		viewInPrint 1
		charNum 14
		keepWindow 1
	)
	
	(method (init)
		(super init: oBust oEyes oMouth &rest)
	)
)

(instance oBust of EcoProp
	(properties
		view 242
		cel 1
	)
)

(instance oEyes of EcoProp
	(properties
		nsTop 12
		nsLeft 10
		view 242
		loop 2
		cycleSpeed 30
	)
)

(instance oMouth of EcoProp
	(properties
		nsTop 12
		nsLeft 18
		view 242
		loop 1
		cycleSpeed 10
	)
)

(instance Oracle of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 157
		viewInPrint 1
		charNum 1
		keepWindow 1
	)
	
	(method (init)
		(super init: oracleBust oracleEye oracleMouth &rest)
	)
)

(instance oracleBust of EcoProp
	(properties
		view 157
	)
)

(instance oracleEye of EcoProp
	(properties
		nsTop 16
		nsLeft 34
		view 157
		loop 2
		cycleSpeed 30
	)
)

(instance oracleMouth of EcoProp
	(properties
		nsTop 17
		nsLeft 39
		view 157
		loop 1
		cycleSpeed 10
	)
)
