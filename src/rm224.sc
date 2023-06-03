;;; Sierra Script 1.0 - (do not remove this comment)
(script# 224)
(include sci.sh)
(use Main)
(use ApartmentRoom)
(use n804)
(use Garbage)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Polygon)
(use ForwardCounter)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm224 0
)

(local
	local0 =  -1
)
(instance rm224 of ApartmentRoom
	(properties
		picture 220
		style $8007
		east 200
		south 200
		lookStr 26
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(= gBelongsTo 9)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						-10
						319
						-10
						319
						182
						269
						143
						310
						75
						304
						33
						226
						12
						92
						19
						35
						48
						29
						102
						50
						146
						136
						161
						239
						189
					yourself:
				)
			setRegions: 51
		)
		(super init: &rest)
		(if (not (proc819_5 49))
			(if (proc819_5 114)
				(seaTurtle init: view: 229 loop: 3 cel: 0)
			else
				(seaTurtle init:)
			)
		)
		(if (and (not (proc819_5 295)) (proc819_5 294))
			(fallBalloon init:)
		)
		(globe init:)
		(balloonOnGround init:)
		(bookcase init:)
		(plant addToPic:)
		(wheel addToPic:)
		(plant1 addToPic:)
		(clock addToPic:)
		(Bflag addToPic:)
		(bed addToPic:)
	)
	
	(method (notify)
		(gEgo setPri: 7)
		(proc0_2)
	)
)

(instance handOnString of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 1) init: 2 0 0 26 1 self)
			)
			(1
				(gEgo hide:)
				(seaTurtle
					view: 229
					loop: 1
					cel: 0
					x: 70
					y: 91
					cycleSpeed: 15
					illegalBits: 0
					setCycle: CT 3 1 self
				)
			)
			(2 (= cycles 19))
			(3
				(seaTurtle cel: 2)
				(= cycles 20)
			)
			(4
				(seaTurtle cel: 3)
				(= cycles 20)
			)
			(5
				(proc0_4 5 293)
				(proc819_3 114)
				(seaTurtle cel: 2)
				(= cycles 20)
			)
			(6
				(if (== register 4)
					(EcoNarrator posn: -1 15 init: 3 0 0 88 self)
				else
					(EcoNarrator posn: -1 15 init: 4 0 0 6 self)
				)
			)
			(7
				(seaTurtle cycleSpeed: 15 setCycle: End self)
			)
			(8
				(gSoundEffects number: 215 loop: 1 play:)
				(seaTurtle view: 229 loop: 3 cel: 0 x: 70 y: 91)
				(= cycles 1)
			)
			(9
				(self setScript: fallOnBooty self)
			)
			(10
				(EcoNarrator posn: -1 15 init: 3 0 0 89 self)
			)
			(11 (proc0_2) (self dispose:))
		)
	)
)

(instance getBalloon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 1) init: 2 0 0 28 1 self)
			)
			(1
				(proc0_4 5 293)
				(gEgo hide:)
				(seaTurtle
					view: 229
					loop: 2
					cel: 0
					x: 70
					y: 91
					cycleSpeed: 15
					illegalBits: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(EcoNarrator posn: -1 15 init: 3 0 0 90 self)
			)
			(3
				(seaTurtle setCycle: End self)
			)
			(4
				(seaTurtle view: 229 loop: 3 cel: 0 posn: 70 91)
				(= cycles 1)
			)
			(5
				(proc0_4 5 294)
				(gSoundEffects number: 216 loop: 1 play:)
				(fallBalloon
					illegalBits: 0
					view: 229
					setLoop: 5
					cel: 0
					posn: 87 103
					setPri: 5
					init:
					yStep: 2
					cycleSpeed: 15
					setCycle: ForwardCounter 3
					setMotion: MoveTo 87 125 fallBalloon
				)
				(self setScript: fallOnBooty self)
			)
			(6
				(Erroneous init: 1 0 0 1 1 self)
			)
			(7
				((ScriptID 2 1) init: 2 0 0 20 1 self)
			)
			(8
				(Erroneous init: 1 0 0 2 1 self)
			)
			(9
				((ScriptID 2 1) init: 2 0 0 21 1 self)
			)
			(10
				(Erroneous init: 1 0 0 3 0 self)
			)
			(11
				(Erroneous init: 1 0 0 8 1 self)
			)
			(12
				((ScriptID 2 1) init: 2 0 0 22 1 self)
			)
			(13
				(Erroneous init: 1 0 0 4 1 self)
			)
			(14
				((ScriptID 2 1) init: 2 0 0 23 1 self)
			)
			(15
				(Erroneous init: 1 0 0 5 0 self)
			)
			(16
				(Erroneous init: 1 0 0 9 1 self)
			)
			(17
				(seaTurtle
					view: 229
					loop: 3
					cel: 0
					x: 70
					y: 91
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(18
				(gEgo setMotion: MoveTo 87 104 self)
			)
			(19
				(proc0_4 2 297)
				(gEgo hide:)
				(seaTurtle
					view: 229
					loop: 4
					posn: 70 91
					cycleSpeed: 15
					setCycle: End self
				)
				(gEgo get: 4)
			)
			(20
				((ScriptID 2 1) init: 2 0 0 24 1 self)
			)
			(21
				(Erroneous init: 1 0 0 6 1 self)
			)
			(22
				((ScriptID 2 1) init: 2 0 0 25 1 self)
			)
			(23
				(Erroneous init: 1 0 0 7 1 self)
			)
			(24
				(proc819_6)
				(gEgo show: setPri: 7)
				(gEgo setMotion: MoveTo 140 105 self)
				(seaTurtle
					view: 246
					loop: 4
					cel: 0
					cycleSpeed: 17
					setCycle: End self
				)
			)
			(25 0)
			(26
				(seaTurtle
					view: 246
					loop: 1
					cel: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(27 (gEgo setHeading: 180 self))
			(28 (= cycles 12))
			(29
				(seaTurtle
					setLoop: 3
					cycleSpeed: 11
					setCycle: Walk
					setMotion: MoveTo 333 210 self
				)
			)
			(30
				(proc819_3 49)
				(seaTurtle dispose:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance fallOnBooty of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					show:
					setCycle: 0
					view: 221
					loop: 1
					cel: 8
					posn: 112 123
					setPri: 14
					cycleSpeed: 5
					setCycle: CT 4 -1 self
				)
			)
			(1
				(gLongSong2 number: 209 loop: 1 play:)
				(gEgo setCycle: CT 1 -1 self)
			)
			(2
				(gLongSong2 number: 209 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo cel: 5 posn: 135 126)
				(= cycles 1)
			)
			(4
				(proc819_6)
				(gEgo posn: 125 113 setPri: 7)
				(= cycles 12)
			)
			(5 (self dispose:))
		)
	)
)

(instance trashBalloon1 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 97 99 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 229
					loop: 7
					cel: 0
					posn: 99 104
					cycleSpeed: 8
					setCycle: CT 5 1 self
				)
			)
			(2
				(fallBalloon dispose:)
				(proc0_4 5 295)
				(gEgo setCycle: End self)
			)
			(3
				(proc819_6)
				(gEgo posn: 94 102 setPri: 7)
				(= cycles 2)
			)
			(4
				(EcoNarrator posn: -1 15 init: 3 0 0 5 self)
			)
			(5 (proc0_2) (self dispose:))
		)
	)
)

(instance trashBalloon2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 210 104 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 229
					loop: 7
					cel: 0
					posn: 214 108
					cycleSpeed: 8
					setCycle: CT 5 1 self
				)
			)
			(2
				(balloonOnGround setFlag:)
				(balloonOnGround dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(proc0_4 5 296)
				(proc819_6)
				(gEgo posn: 211 108 setPri: 7)
				(= cycles 2)
			)
			(4
				(EcoNarrator posn: -1 15 init: 3 0 0 5 self)
			)
			(5 (proc0_2) (self dispose:))
		)
	)
)

(instance seaTurtle of EcoActor
	(properties
		x 70
		y 91
		view 229
		signal $5000
	)
	
	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 2 9 1
			approachX: 87
			approachY: 104
			stopUpd:
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (not (proc819_5 114)) (EcoNarrator store: 97))
				(EcoNarrator init: 3 0 0 4 self)
			)
			(4
				(if (proc819_5 114)
					(EcoNarrator init: 3 0 0 65)
				else
					(global2 setScript: handOnString 0 theVerb)
				)
			)
			(2
				(if (proc819_3 144)
					(EcoNarrator init: 3 0 0 64)
				else
					(EcoNarrator init: 3 0 0 64)
				)
			)
			(44
				(switch temp0
					(15
						(if (proc819_5 114)
							(global2 setScript: getBalloon)
						else
							(global2 setScript: handOnString 0 theVerb)
						)
					)
					(12
						(EcoNarrator init: 3 0 0 95)
					)
					(16
						(EcoNarrator init: 3 0 0 93)
					)
					(17
						(EcoNarrator init: 3 0 0 94)
					)
					(else 
						(EcoNarrator init: 3 0 0 96)
					)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 103)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance balloonOnGround of Garbage
	(properties
		x 201
		y 132
		z 3
		view 229
		loop 6
		flag 39
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 66))
			(4 (EcoNarrator init: 3 0 0 98))
			(6
				(global2 setScript: trashBalloon2)
			)
			(44
				(EcoNarrator init: 3 0 0 104)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fallBalloon of EcoActor
	(properties
		x 87
		y 125
		view 229
		loop 6
		signal $4011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 67))
			(4 (EcoNarrator init: 3 0 0 98))
			(6
				(global2 setScript: trashBalloon1)
			)
			(44
				(EcoNarrator init: 3 0 0 104)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (cue)
		(self setPri: 0 loop: 6 cel: 0)
	)
)

(instance bed of EcoView
	(properties
		x 90
		y 130
		view 228
		signal $1011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 73))
			(4 (EcoNarrator init: 3 0 0 22))
			(44
				(EcoNarrator init: 3 0 0 101)
			)
			(6
				(EcoNarrator init: 3 0 0 102)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Bflag of EcoView
	(properties
		x 61
		y 91
		view 228
		loop 2
		cel 1
		signal $1011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 68))
			(4 (EcoNarrator init: 3 0 0 24))
			(44
				(EcoNarrator init: 3 0 0 101)
			)
			(6
				(EcoNarrator init: 3 0 0 102)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance clock of EcoView
	(properties
		x 126
		y 106
		view 228
		cel 1
		signal $1011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 69))
			(4 (EcoNarrator init: 3 0 0 21))
			(44
				(EcoNarrator init: 3 0 0 101)
			)
			(6
				(EcoNarrator init: 3 0 0 102)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant1 of EcoView
	(properties
		x 249
		y 122
		view 228
		loop 2
		signal $1011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 11))
			(4 (EcoNarrator init: 3 0 0 19))
			(44
				(EcoNarrator init: 3 0 0 101)
			)
			(6
				(EcoNarrator init: 3 0 0 102)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance bookcase of EcoFeature
	(properties
		x 231
		y 129
		z 48
		nsTop 66
		nsLeft 202
		nsBottom 96
		nsRight 261
		sightAngle 90
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(switch (= local0 (mod (++ local0) 15))
					(0 (EcoNarrator init: 3 0 0 71))
					(1 (EcoNarrator init: 3 0 0 74))
					(2 (EcoNarrator init: 3 0 0 75))
					(3 (EcoNarrator init: 3 0 0 76))
					(4 (EcoNarrator init: 3 0 0 77))
					(5 (EcoNarrator init: 3 0 0 78))
					(6 (EcoNarrator init: 3 0 0 79))
					(7 (EcoNarrator init: 3 0 0 80))
					(8 (EcoNarrator init: 3 0 0 81))
					(9 (EcoNarrator init: 3 0 0 82))
					(10
						(EcoNarrator init: 3 0 0 83)
					)
					(11
						(EcoNarrator init: 3 0 0 84)
					)
					(12
						(EcoNarrator init: 3 0 0 85)
					)
					(13
						(EcoNarrator init: 3 0 0 86)
					)
					(14
						(EcoNarrator init: 3 0 0 87)
					)
				)
			)
			(4 (EcoNarrator init: 3 0 0 20))
			(44
				(EcoNarrator init: 3 0 0 101)
			)
			(6
				(EcoNarrator init: 3 0 0 102)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance globe of EcoFeature
	(properties
		x 221
		y 130
		z 34
		nsTop 49
		nsLeft 212
		nsBottom 65
		nsRight 230
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 72))
			(4 (EcoNarrator init: 3 0 0 23))
			(44
				(EcoNarrator init: 3 0 0 101)
			)
			(6
				(EcoNarrator init: 3 0 0 102)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wheel of EcoView
	(properties
		x 260
		y 53
		view 228
		loop 1
		cel 1
		signal $1011
	)
	
	(method (init)
		(super init: &rest)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoMouseDownHandler delete: self)
		(gEcoKeyDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(User canInput:)
				(not (global2 script?))
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
				(!= (pEvent type?) evVERB)
				(not (pEvent modifiers?))
				(== (gIconBar curIcon?) (gIconBar at: 4))
				(== (gIconBar curInvIcon?) (Inv at: 4))
			)
			(EcoNarrator init: 3 0 0 105)
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
			(1 (EcoNarrator init: 3 0 0 70))
			(4 (EcoNarrator init: 3 0 0 25))
			(44
				(EcoNarrator init: 3 0 0 101)
			)
			(6
				(EcoNarrator init: 3 0 0 102)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant of EcoView
	(properties
		x 101
		y 185
		view 228
		loop 1
		priority 15
		signal $1011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(plant1 doVerb: theVerb temp0 &rest)
	)
)

(instance Erroneous of EcoTalker
	(properties
		nsTop 16
		nsLeft 10
		view 239
		viewInPrint 1
		charNum 13
		keepWindow 1
	)
	
	(method (init)
		(super init: eBust eEyes eMouth &rest)
	)
)

(instance eBust of EcoProp
	(properties
		view 239
	)
)

(instance eEyes of EcoProp
	(properties
		nsTop 16
		nsLeft 10
		view 239
		loop 2
		cycleSpeed 30
	)
)

(instance eMouth of EcoProp
	(properties
		nsTop 19
		nsLeft 4
		view 239
		loop 1
		cycleSpeed 10
	)
)
