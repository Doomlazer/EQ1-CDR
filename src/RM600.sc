;;; Sierra Script 1.0 - (do not remove this comment)
(script# 600)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use Obj)

(public
	RM600 0
)

(local
	local0
)
(instance RM600 of EcoRoom
	(properties
		picture 600
		style $8007
		horizon 10
		south 580
		picAngle 70
		vanishingX 180
		vanishingY 44
		lookStr 4
	)
	
	(method (init)
		(= global250 1)
		(proc819_6)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						0
						319
						0
						319
						189
						197
						189
						233
						170
						285
						166
						237
						162
						266
						145
						228
						145
						233
						137
						209
						137
						180
						117
						143
						117
						154
						129
						66
						140
						56
						168
						171
						189
					yourself:
				)
		)
		(Load rsVIEW 600)
		(gFeatures
			add: skeletonBits skeleton1 hook skeleton2
			eachElementDo: #init
		)
		(if (== gSouth 580)
			(proc958_0 128 601 602)
			(gEgo init: z: 20)
			(if (not (proc819_5 71))
				(dolphin init: setScript: bugEgoALot setCycle: Fwd)
			)
			(self setScript: enterCave)
		else
			(gEgo setCycle: 0)
			(proc958_0 128 603 582)
			(dolphin view: 603 loop: 6 cel: 0 init: setCycle: Fwd)
			(self setScript: mantaCartoon)
		)
		(seaweed1 init: setCycle: Fwd)
		(seaweed2 init: setCycle: Fwd)
		(seaweed3 init: setCycle: Fwd)
		(seaweed4 init: setCycle: Fwd)
		(super init: &rest)
		(if (and (not (proc819_5 71)) (== gSouth 580))
			(gLongSong number: 665 loop: -1 play: hold: 10)
		else
			(gLongSong number: 600 loop: -1 play:)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 4))
			(4 (EcoNarrator init: 1 0 0 29))
			(44
				(EcoNarrator init: 1 0 0 30)
			)
			(2 (gEgo setScript: talkToCave))
			(6 (EcoNarrator init: 1 0 0 31))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance enterCave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo posn: 184 230 setMotion: MoveTo 173 168 self)
			)
			(1 (proc0_2) (self dispose:))
		)
	)
)

(instance talkToCave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(1
				((ScriptID 2 0) init: 3 0 0 7 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance bugEgoALot of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(self setScript: (ScriptID 127 0) 0 918)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 20))
			(1
				(if (not (global2 script?))
					((ScriptID 2 0)
						init: 3 0 0 (+ (= local0 (mod (++ local0) 4)) 1) 1 self
					)
				else
					(= ticks 3)
				)
			)
			(2 (self changeState: 0))
		)
	)
)

(instance cutDownDelph of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_3 71)
				(gEgo setMotion: PolyPath 175 146 self)
			)
			(1
				(gEgo setMotion: MoveTo 193 128 self)
			)
			(2
				(= register (gEgo z?))
				(gEgo setCycle: 0)
				(= seconds 1)
			)
			(3
				(gEgo
					view: 601
					setLoop: 0
					cel: 0
					posn: 193 108
					z: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(4
				(dolphin hide:)
				(gEgo view: 602 loop: 0 cel: 0 posn: 174 87)
				((ScriptID 2 0) init: 3 0 0 5 1 self)
			)
			(5
				((dolphin script?) setScript: 0)
				(proc0_4 15 335)
				(gEgo setCycle: CT 10 1 self)
			)
			(6
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(7
				(gSoundEffects number: 602 loop: 1 play:)
				(gLongSong hold: 0)
				(gEgo cel: 11 setCycle: End self)
			)
			(8
				(gEgo view: 601 loop: 1 cel: 10 posn: 194 78)
				(net
					init:
					setLoop: 3
					setMotion: MoveTo 5 104
					setCycle: Fwd
				)
				(dolphin
					show:
					view: 602
					loop: 1
					cel: 0
					x: 173
					y: 158
					priority: 15
					setCycle: CT 9 1 self
				)
			)
			(9
				((ScriptID 2 0) init: 3 0 0 6 1 self)
			)
			(10
				(gSoundEffects number: 921 loop: 1 play:)
				(dolphin setCycle: End self)
			)
			(11
				(dolphin dispose:)
				(gEgo setCycle: End self)
			)
			(12
				(net dispose:)
				(proc819_6 2)
				(gEgo
					posn: 198 92
					z: register
					setMotion: PolyPath 170 200 self
				)
			)
			(13 (proc0_2) (self dispose:))
		)
	)
)

(instance dolphinSwing of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin view: 603 loop: 4 cel: 0 setCycle: End self)
			)
			(1
				(dolphin view: 603 loop: 6 cel: 0 setCycle: Fwd)
			)
			(2
				(dolphin view: 603 loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(dolphin view: 603 loop: 6 cel: 0 setCycle: Fwd)
			)
			(4
				(dolphin view: 603 loop: 5 cel: 0 setCycle: End self)
			)
			(5
				(= state 1)
				(dolphin view: 603 loop: 6 cel: 0 setCycle: Fwd)
			)
		)
	)
)

(instance mantaCartoon of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(self setScript: (ScriptID 127 0) 0 918)
	)
	
	(method (changeState newState &tmp [temp0 500])
		(switch (= state newState)
			(0
				(proc0_1)
				(dolphin setPri: 9)
				(manta
					loop: 0
					cel: 0
					posn: 132 71
					cycleSpeed: 20
					init:
					setPri: 8
					setCycle: CT 5 1 self
				)
			)
			(1
				(dolphin setScript: dolphinSwing)
				(manta setCycle: End self)
			)
			(2
				(EcoNarrator init: 1 0 0 19 self)
			)
			(3 (manta hide:) (= seconds 3))
			(4
				(manta
					show:
					loop: 1
					cel: 0
					posn: 141 78
					cycleSpeed: 20
					setPri: 8
					setCycle: CT 3 1 self
				)
			)
			(5
				(dolphinSwing cue:)
				(manta setCycle: End self)
			)
			(6 (manta hide:) (= seconds 3))
			(7
				(manta
					show:
					loop: 2
					cel: 0
					posn: 214 79
					cycleSpeed: 20
					setPri: 9
					setCycle: CT 3 1 self
				)
			)
			(8
				(dolphinSwing cue:)
				(manta setCycle: End self)
			)
			(9 (manta hide:) (= seconds 3))
			(10
				(manta
					show:
					loop: 1
					cel: 0
					posn: 141 78
					cycleSpeed: 20
					setPri: 8
					setCycle: CT 3 1 self
				)
			)
			(11
				(dolphinSwing cue:)
				(manta setCycle: End self)
			)
			(12
				(manta hide:)
				(= seconds 3)
			)
			(13
				(manta
					show:
					loop: 2
					cel: 0
					posn: 214 79
					cycleSpeed: 20
					setPri: 9
					setCycle: CT 3 1 self
				)
			)
			(14
				(dolphinSwing cue:)
				(manta setCycle: End self)
			)
			(15
				(manta hide:)
				(= seconds 3)
			)
			(16
				(dolphin setScript: 0)
				(manta
					show:
					view: 582
					setLoop: 0
					cel: 0
					setCycle: Fwd
					posn: 312 1
					setPri: -1
					setMotion: MoveTo 237 64 self
				)
			)
			(17 (= seconds 3))
			(18
				(EcoNarrator init: 1 0 0 20 self)
			)
			(19
				(gSoundEffects number: 645 loop: 1 play:)
				(EcoNarrator init: 4 0 0 29 self)
			)
			(20
				(EcoNarrator init: 1 0 0 21 self)
			)
			(21
				(proc0_2)
				(global2 newRoom: 580)
			)
		)
	)
)

(instance seaweed1 of EcoProp
	(properties
		x 112
		y 184
		view 600
		priority 15
		signal $4010
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 31))
			(4 (EcoNarrator init: 1 0 0 17))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seaweed2 of EcoProp
	(properties
		x 48
		y 171
		view 600
		loop 1
		cel 1
		priority 15
		signal $4010
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 31))
			(4 (EcoNarrator init: 1 0 0 17))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seaweed3 of EcoProp
	(properties
		x 217
		y 185
		view 600
		loop 2
		cel 4
		priority 15
		signal $4010
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 31))
			(4 (EcoNarrator init: 1 0 0 17))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seaweed4 of EcoProp
	(properties
		y 189
		view 600
		loop 3
		cel 1
		priority 15
		signal $4010
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 31))
			(4 (EcoNarrator init: 1 0 0 17))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dolphin of EcoProp
	(properties
		x 176
		y 84
		view 602
		loop 2
		cel 3
		signal $4010
		lookStr 6
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 18))
			(44
				(switch temp0
					(17
						(global2 setScript: cutDownDelph)
					)
					(37
						(EcoNarrator init: 1 0 0 23)
					)
					(29
						(EcoNarrator init: 1 0 0 22)
					)
					(12
						(EcoNarrator init: 1 0 0 24)
					)
					(15
						(EcoNarrator init: 1 0 0 25)
					)
					(30
						(EcoNarrator init: 1 0 0 26)
					)
					(else 
						(EcoNarrator init: 1 0 0 27)
					)
				)
			)
			(2
				((ScriptID 2 1) init: 2 0 0 9 1)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance manta of EcoActor
	(properties
		x 141
		y 78
		view 603
		loop 1
		cel 4
		priority 6
		signal $6010
		cycleSpeed 1
		illegalBits $0000
	)
)

(instance net of EcoActor
	(properties
		x 149
		y 77
		view 602
		loop 3
		signal $4000
		cycleSpeed 15
		xStep 6
	)
)

(instance skeletonBits of EcoFeature
	(properties
		onMeCheck $4000
		lookStr 1
	)
	
	(method (doVerb theVerb)
		(self
			x: ((gUser curEvent?) x?)
			y: ((gUser curEvent?) y?)
		)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 31))
			(4
				((ScriptID 2 1) init: 2 0 0 3 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skeleton1 of EcoFeature
	(properties
		onMeCheck $2000
		lookStr 2
	)
	
	(method (doVerb theVerb)
		(self
			x: ((gUser curEvent?) x?)
			y: ((gUser curEvent?) y?)
		)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 31))
			(4 (EcoNarrator init: 1 0 0 14))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skeleton2 of EcoFeature
	(properties
		onMeCheck $1000
		lookStr 3
	)
	
	(method (doVerb theVerb)
		(self
			x: ((gUser curEvent?) x?)
			y: ((gUser curEvent?) y?)
		)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 31))
			(4
				((ScriptID 2 1) init: 2 0 0 2 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hook of EcoFeature
	(properties
		x 175
		y 64
		onMeCheck $0800
		lookStr 5
	)
	
	(method (doVerb theVerb &tmp temp0)
		(self
			x: ((gUser curEvent?) x?)
			y: ((gUser curEvent?) y?)
		)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 31))
			(44
				(switch temp0
					(37
						(EcoNarrator init: 1 0 0 10)
					)
					(else 
						(EcoNarrator init: 1 0 0 11)
					)
				)
			)
			(4 (EcoNarrator init: 1 0 0 8))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)
