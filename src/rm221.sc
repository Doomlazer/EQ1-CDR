;;; Sierra Script 1.0 - (do not remove this comment)
(script# 221)
(include sci.sh)
(use Main)
(use ApartmentRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use n958)
(use DPath)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm221 0
)

(instance rm221 of ApartmentRoom
	(properties
		picture 220
		style $8007
		east 200
		south 200
		lookStr 110
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(= gBelongsTo 6)
		(proc958_0 128 221 223 802 222)
		(self setRegions: 51)
		(if (proc819_5 47) (self setScript: fallIn))
		(super init: &rest)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						175
						419
						175
						254
						134
						304
						89
						301
						28
						227
						12
						119
						12
						35
						52
						36
						114
						65
						150
						170
						170
						288
						189
						288
						259
						-100
						259
						-100
						-70
						419
						-70
					yourself:
				)
		)
		(table init:)
		(paintcan init:)
		(palet init:)
		(urchns init:)
		(roundStatue init:)
		(redSeaweed addToPic:)
		(fishStatue addToPic:)
		(stackedPaintings addToPic:)
		(easel addToPic:)
		(painting addToPic:)
		(purplePlant addToPic:)
		(redPlant addToPic:)
		(if (proc819_5 92)
			(plasticBaggie cel: 4 posn: 165 112 init:)
		)
		(if (not (proc819_5 52))
			(blowFish setCycle: Fwd init:)
		)
		(if
			(and
				(not (== ((Inv at: 7) owner?) 222))
				(not (gEgo has: 7))
			)
			(narUrchin setCycle: Fwd init:)
		)
	)
	
	(method (notify)
		(proc0_2)
	)
)

(instance fallIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_4 47)
				(gEgo
					setCycle: 0
					setLoop: 0
					cel: 3
					posn: 308 133
					setPri: 13
				)
				(= cycles 3)
			)
			(1
				(gSoundEffects number: 208 loop: 1 play:)
				(gEgo setCycle: 0 view: 221)
				(= cycles 1)
			)
			(2
				(gEgo cel: 0 posn: 309 122)
				(= cycles 1)
			)
			(3
				(gEgo cel: 1 posn: 287 115)
				(= cycles 2)
			)
			(4
				(gEgo cel: 2 posn: 275 119)
				(= cycles 2)
			)
			(5
				(gEgo cel: 3 posn: 263 131)
				(= cycles 4)
			)
			(6
				(gEgo cel: 0 posn: 260 122)
				(= cycles 6)
			)
			(7
				(gEgo cel: 1 posn: 239 117 setPri: 10)
				(= cycles 9)
			)
			(8
				(gEgo cel: 2 posn: 223 132)
				(= cycles 9)
			)
			(9
				(gEgo
					setCycle: 0
					setLoop: 1
					cel: 0
					posn: 194 135
					setPri: 12
					cycleSpeed: 15
				)
				(= cycles 15)
			)
			(10
				(gSoundEffects number: 209 loop: 1 play:)
				(gEgo cel: 1 setCycle: CT 3 1 self)
			)
			(11
				(gSoundEffects number: 209 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(12
				(proc819_6)
				(gEgo posn: 173 122)
				(= cycles 1)
			)
			(13
				(gLongSong number: 201 loop: -1 play:)
				(EcoNarrator init: 3 0 0 111 self)
			)
			(14 (proc0_2) (self dispose:))
		)
	)
)

(instance unwrapNarci of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 180 91 self)
			)
			(1 (= cycles 10))
			(2 (gEgo setHeading: 270 self))
			(3
				(gEgo
					setCycle: 0
					view: 221
					loop: 2
					cel: 0
					x: 162
					y: 69
					cycleSpeed: 22
					setCycle: CT 2 1 self
				)
			)
			(4
				(EcoNarrator init: 3 0 0 118 self)
			)
			(5
				(blowFish hide:)
				(gEgo
					view: 221
					loop: 2
					cel: 2
					x: 162
					y: 69
					cycleSpeed: 18
					setCycle: CT 6 1 self
				)
			)
			(6
				(proc0_4 10 281)
				(blowFish view: 223 loop: 5 cel: 0 x: 143 y: 62 show:)
				(proc819_6)
				(gEgo posn: 149 92)
				(= cycles 1)
			)
			(7
				(gEgo setMotion: DPath 170 85 186 75 self)
				(plasticBaggie
					view: 221
					setLoop: 3
					cel: 0
					posn: 186 86
					init:
					setCycle: Fwd
					setMotion: MoveTo 185 112 self
				)
				(blowFish cycleSpeed: 3 setCycle: End self)
			)
			(8 0)
			(9 0)
			(10 (gEgo setHeading: 270 self))
			(11
				(plasticBaggie
					view: 221
					loop: 3
					cel: 4
					posn: 185 112
					setCycle: 0
					stopUpd:
				)
				(proc819_3 92)
				(= cycles 3)
			)
			(12
				((ScriptID 2 1) init: 1 0 0 2 1 self)
			)
			(13
				(Narcissus init: 2 0 0 1 1 self)
			)
			(14
				((ScriptID 2 1) init: 1 0 0 3 1 self)
			)
			(15
				(Narcissus init: 2 0 0 2 1 self)
			)
			(16
				((ScriptID 2 1) init: 1 0 0 4 1 self)
			)
			(17
				(Narcissus init: 2 0 0 3 1 self)
			)
			(18
				(blowFish
					view: 250
					loop: 0
					cel: 0
					posn: 132 80
					setPri: 14
					cycleSpeed: 15
					setCycle: Fwd
				)
				(gEgo
					setCycle: 0
					view: 805
					setLoop: gStopGroop
					cel: 0
					xStep: 1
					moveSpeed: 8
					cycleSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 160 75 self
				)
			)
			(19 (= seconds 2))
			(20
				((ScriptID 2 1) init: 1 0 0 5 1 self)
			)
			(21
				(Narcissus init: 2 0 0 4 1 self)
			)
			(22
				((ScriptID 2 1) init: 1 0 0 6 1 self)
			)
			(23
				(Narcissus init: 2 0 0 5 1 self)
			)
			(24
				(gEgo xStep: 2 moveSpeed: 7 setMotion: MoveTo 186 75 self)
			)
			(25 (gEgo setHeading: 270 self))
			(26
				(Narcissus init: 2 0 0 6 1 self)
			)
			(27
				(blowFish
					view: 223
					loop: 7
					cel: 0
					x: 107
					y: 75
					cycleSpeed: 12
					setCycle: CT 8 1 self
				)
			)
			(28
				(narUrchin dispose:)
				(blowFish setCycle: End self)
			)
			(29
				(gEgo hide:)
				(blowFish
					view: 223
					loop: 6
					cel: 0
					x: 174
					y: 66
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(30 (= cycles 3))
			(31
				(proc0_4 2 283)
				(proc819_6)
				(gEgo posn: 187 70 get: 7 show:)
				(blowFish
					view: 250
					loop: 0
					cel: 0
					posn: 132 80
					setPri: 14
					setCycle: Walk
				)
				(= cycles 12)
			)
			(32
				((ScriptID 2 1) init: 1 0 0 7 1 self)
			)
			(33
				(Narcissus init: 2 0 0 7 1 self)
			)
			(34 (gEgo setHeading: 180 self))
			(35 (= cycles 12))
			(36
				(blowFish setMotion: DPath 239 156 330 192 self)
			)
			(37
				(proc819_3 52)
				(blowFish dispose:)
				(= cycles 1)
			)
			(38 (proc0_2) (self dispose:))
		)
	)
)

(instance getBaggie of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_4 92)
				(gEgo setMotion: MoveTo 149 74 self)
			)
			(1 (= cycles 12))
			(2
				(gEgo
					setCycle: 0
					view: 221
					loop: 4
					cel: 0
					posn: 151 88
					cycleSpeed: 12
					setCycle: CT 6 1 self
				)
			)
			(3
				(plasticBaggie dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(proc0_4 5 282)
				(proc819_6)
				(gEgo posn: 178 76)
				(= cycles 1)
			)
			(5
				(EcoNarrator init: 3 0 0 3 self)
			)
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance lookAtUrchns of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 3 0 0 39 self)
			)
			(1
				(if (gCast contains: narUrchin)
					(EcoNarrator init: 3 0 0 28 self)
				else
					(= cycles 1)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance blowFish of EcoActor
	(properties
		x 160
		y 57
		yStep 3
		view 223
		loop 8
		signal $5000
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 34))
			(4
				(global2 setScript: unwrapNarci)
			)
			(2 (EcoNarrator init: 3 0 0 35))
			(6
				(EcoNarrator init: 3 0 0 116)
			)
			(44
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 112)
					)
					(29
						(EcoNarrator init: 3 0 0 120)
					)
					(else 
						(EcoNarrator init: 3 0 0 113)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plasticBaggie of EcoActor
	(properties
		x 186
		y 86
		view 221
		loop 3
		cel 4
		priority 1
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 40))
			(4 (EcoNarrator init: 3 0 0 41))
			(44
				(EcoNarrator init: 3 0 0 127)
			)
			(6
				(global2 setScript: getBaggie)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance narUrchin of EcoProp
	(properties
		x 88
		y 101
		view 223
		loop 10
		priority 10
		signal $5010
		cycleSpeed 45
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 39))
			(4
				(EcoNarrator init: 3 0 0 107)
			)
			(2
				(EcoNarrator init: 3 0 0 114)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 117)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance roundStatue of EcoFeature
	(properties
		x 280
		y 143
		z 24
		nsTop 107
		nsLeft 270
		nsBottom 132
		nsRight 291
		sightAngle 90
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator init: 3 0 0 124)
			)
			(4
				(EcoNarrator init: 3 0 0 125)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(2
				(EcoNarrator init: 3 0 0 126)
			)
			(6
				(EcoNarrator init: 3 0 0 115)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance urchns of EcoFeature
	(properties
		x 78
		y 135
		z 30
		sightAngle 90
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(global2 setScript: lookAtUrchns)
			)
			(4
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 108)
				else
					(EcoNarrator init: 3 0 0 107)
				)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 117)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (onMe param1)
		(if (proc999_4 73 90 84 100 param1)
		else
			(proc999_4 68 101 93 106 param1)
		)
	)
)

(instance table of EcoFeature
	(properties
		x 82
		y 157
		z 30
		nsTop 107
		nsLeft 69
		nsBottom 127
		nsRight 95
		sightAngle 90
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(global2 setScript: lookAtUrchns)
			)
			(4
				(EcoNarrator init: 3 0 0 106)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 117)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance paintcan of EcoFeature
	(properties
		x 143
		y 93
		nsTop 88
		nsLeft 139
		nsBottom 99
		nsRight 148
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 28))
			(4
				(EcoNarrator init: 3 0 0 101)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 117)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance palet of EcoFeature
	(properties
		x 115
		y 103
		nsTop 95
		nsLeft 105
		nsBottom 112
		nsRight 126
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 96))
			(4 (EcoNarrator init: 3 0 0 97))
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 117)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance redSeaweed of EcoView
	(properties
		x 257
		y 190
		view 222
		loop 1
		priority 15
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 11))
			(4 (EcoNarrator init: 3 0 0 19))
			(6
				(EcoNarrator init: 3 0 0 117)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fishStatue of EcoView
	(properties
		x 255
		y 102
		view 222
		loop 1
		cel 1
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 37))
			(4
				(EcoNarrator init: 3 0 0 104)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(2
				(EcoNarrator init: 3 0 0 126)
			)
			(6
				(EcoNarrator init: 3 0 0 115)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance stackedPaintings of EcoView
	(properties
		x 286
		y 137
		view 222
		loop 1
		cel 2
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 38))
			(4
				(EcoNarrator init: 3 0 0 105)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(2
				(EcoNarrator init: 3 0 0 126)
			)
			(6
				(EcoNarrator init: 3 0 0 115)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance easel of EcoView
	(properties
		x 109
		y 72
		z -56
		view 222
		loop 2
		signal $5011
	)
	
	(method (init)
		(super init: &rest)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(User canInput:)
				(not (global2 script?))
				(!= (pEvent type?) evVERB)
				(not (pEvent modifiers?))
				(not
					(proc999_5
						(pEvent message?)
						9
						17
						15104
						15360
						16128
						16640
						17152
					)
				)
				(== (gIconBar curIcon?) (gIconBar at: 4))
				(== (gIconBar curInvIcon?) (Inv at: 7))
			)
			(EcoNarrator init: 3 0 0 119)
			(pEvent claimed: 1)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 36))
			(4
				(EcoNarrator init: 3 0 0 103)
			)
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(2
				(EcoNarrator init: 3 0 0 126)
			)
			(6
				(EcoNarrator init: 3 0 0 115)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance painting of EcoView
	(properties
		x 78
		y 73
		view 222
		loop 2
		cel 1
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 98))
			(4 (EcoNarrator init: 3 0 0 99))
			(44
				(if (proc819_5 281)
					(EcoNarrator init: 3 0 0 122)
				else
					(EcoNarrator init: 3 0 0 121)
				)
			)
			(2
				(EcoNarrator init: 3 0 0 126)
			)
			(6
				(EcoNarrator init: 3 0 0 115)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance purplePlant of EcoView
	(properties
		x 135
		y 160
		view 222
		priority 15
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(redSeaweed doVerb: theVerb temp0 &rest)
	)
)

(instance redPlant of EcoView
	(properties
		x 35
		y 87
		view 222
		cel 1
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(redSeaweed doVerb: theVerb temp0 &rest)
	)
)

(instance Narcissus of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 236
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
