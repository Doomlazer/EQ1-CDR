;;; Sierra Script 1.0 - (do not remove this comment)
(script# 223)
(include sci.sh)
(use Main)
(use ApartmentRoom)
(use n804)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Grooper)
(use Cycle)
(use InvI)
(use Obj)

(public
	rm223 0
)

(local
	gEgoX
	gEgoY
)
(instance rm223 of ApartmentRoom
	(properties
		picture 220
		style $8007
		east 200
		south 200
		lookStr 9
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(= gBelongsTo 5)
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
						178
						289
						178
						266
						163
						305
						82
						298
						41
						226
						11
						105
						16
						49
						42
						56
						99
						101
						105
						121
						132
						73
						149
						172
						168
						249
						189
					yourself:
				)
			setRegions: 51
		)
		(super init: &rest)
		(proc819_6)
		(gEgo setPri: 8)
		(if (== ((Inv at: 34) owner?) 223)
			(rings init: cel: 14 setPri: 0 stopUpd:)
		)
		(if (gEgo has: 6) (tools init:))
		(if (not (proc819_5 50)) (swordFish init:))
		(anotherplant addToPic:)
		(sculpture addToPic:)
		(cabinet addToPic:)
		(cert addToPic:)
		(plant addToPic:)
		(wallplaque addToPic:)
		(plant2 addToPic:)
		(plant1 addToPic:)
		(golfClubs init:)
		(bookCase init:)
	)
	
	(method (notify)
		(proc0_2)
	)
)

(instance firstTalk of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (changeState newState &tmp [temp0 500])
		(switch (= state newState)
			(0 (proc0_1) (= cycles 15))
			(1
				(Hippocrates init: 1 0 0 1 1 self)
			)
			(2
				((ScriptID 2 1) init: 2 0 0 15 1 self)
			)
			(3
				(bubble init: stopUpd:)
				(bubbleFish init:)
				(bubbleFish setCycle: End)
				(= cycles 20)
			)
			(4
				(Hippocrates init: 1 0 0 2 1 self)
				(= cycles 10)
			)
			(5
				(bubble dispose:)
				(bubbleFish dispose:)
				(swordFish setScript: stuckShut)
				(proc0_4 2 287)
				(proc0_2)
				(self dispose:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if (and (pEvent type?) gTheNewEcoDialog)
			(gTheNewEcoDialog dispose:)
			(pEvent claimed: 1)
		else
			(super handleEvent: pEvent)
		)
	)
)

(instance useShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 1) init: 2 0 0 16 1 self)
			)
			(1
				(Hippocrates init: 1 0 0 4 1 self)
			)
			(2
				(gEgo hide:)
				(= gEgoX (gEgo x?))
				(= gEgoY (gEgo y?))
				(swordFish
					view: 238
					loop: 0
					cel: 0
					posn: 182 107
					cycleSpeed: 25
					setCycle: CT 6 1 self
				)
			)
			(3
				((Inv at: 34) owner: 223)
				(rings init: setPri: (+ swordFish 1) setCycle: End rings)
				(swordFish cel: 7 setCycle: CT 9 1 self)
			)
			(4
				(gEgo
					setCycle: 0
					view: 238
					loop: 1
					cel: 0
					posn: (swordFish x?) (swordFish y?)
					show:
					setCycle: End
				)
				(swordFish cel: 10 setCycle: End self)
			)
			(5
				(gEgo view: 805 x: gEgoX y: gEgoY)
				(= seconds 3)
			)
			(6
				(Hippocrates init: 1 0 0 5 0 self)
			)
			(7
				(Hippocrates init: 1 0 0 10 1 self)
			)
			(8
				((ScriptID 2 1) init: 2 0 0 17 1 self)
			)
			(9
				(Hippocrates init: 1 0 0 6 0 self)
			)
			(10
				(Hippocrates init: 1 0 0 11 1 self)
			)
			(11
				((ScriptID 2 1) init: 2 0 0 18 1 self)
			)
			(12
				(Hippocrates init: 1 0 0 7 0 self)
			)
			(13
				(Hippocrates init: 1 0 0 8 1 self)
			)
			(14
				(swordFish
					view: 227
					setCycle: Walk
					cycleSpeed: 8
					setLoop: -1
					setLoop: Grooper
					posn: 177 86
					setHeading: 270 self
				)
			)
			(15
				(swordFish setMotion: MoveTo 146 77 self)
			)
			(16
				(swordFish
					view: 238
					loop: 3
					cel: 0
					posn: 133 94
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(17
				(tools init:)
				(swordFish cel: 3 setCycle: End self)
			)
			(18
				(gEgo view: 238 loop: 4 cel: 0 posn: 184 96)
				(swordFish posn: 184 96 loop: 2 cel: 0)
				(= cycles 2)
			)
			(19
				(if (< (gEgo cel?) 6)
					(-- state)
					(gEgo cel: (+ (gEgo cel?) 1))
					(swordFish cel: (+ (swordFish cel?) 1))
				)
				(= cycles 8)
			)
			(20
				(proc0_4 10 288)
				(gEgo get: 6)
				(EcoNarrator init: 3 0 0 63 self)
			)
			(21
				((ScriptID 2 1) init: 2 0 0 19 1 self)
			)
			(22
				(Hippocrates init: 1 0 0 9 1 self)
			)
			(23
				(proc819_6 1)
				(gEgo x: gEgoX y: gEgoY)
				(= cycles 2)
			)
			(24 (gEgo setHeading: 180 self))
			(25 (= cycles 12))
			(26
				(swordFish
					ignoreActors:
					view: 227
					loop: 0
					heading: 90
					setCycle: Walk
					setMotion: PolyPath 356 178 self
				)
			)
			(27
				(swordFish dispose:)
				(proc819_3 50)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance pickupRings of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 10))
			(1 (gEgo setHeading: 90 self))
			(2 (= cycles 10))
			(3
				(gEgo
					setCycle: 0
					view: 238
					setLoop: 6
					cel: 0
					cycleSpeed: 8
					posn: 144 112
					setCycle: CT 5 1 self
				)
			)
			(4
				(rings dispose:)
				(proc0_4 5 290)
				(gEgo cel: 6 setCycle: End self)
				(if (== register 4)
					(gEgo get: 34)
				else
					((Inv at: 34) owner: 0)
				)
			)
			(5
				(if (== register 6)
					(EcoNarrator init: 3 0 0 3 self)
				else
					(EcoNarrator init: 3 0 0 68 self)
				)
			)
			(6
				(proc819_6 0)
				(gEgo posn: 170 103 setPri: 8)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance stuckShut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(swordFish
					cycleSpeed: 4
					setCycle: RandCycle (Random 3 13) self
				)
			)
			(1
				(= state -1)
				(= cycles (Random 5 30))
			)
		)
	)
)

(instance swordFish of EcoActor
	(properties
		x 177
		y 86
		heading 90
		approachX 220
		approachY 90
		view 251
	)
	
	(method (init)
		(super init: &rest)
		(self
			setCycle: Walk
			ignoreActors:
			setLoop: Grooper
			approachVerbs: 4 9 1 2
			setScript: stuckShut
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (not (gEgo has: 6)) (EcoNarrator init: 3 0 0 54))
			)
			(4 (EcoNarrator init: 3 0 0 55))
			(44
				(switch temp0
					(17
						(self setScript: 0 setCycle: 0 cel: 0)
						(global2 setScript: useShell)
					)
					(12
						(EcoNarrator init: 3 0 0 65)
					)
					(16
						(EcoNarrator init: 3 0 0 66)
					)
					(else 
						(EcoNarrator init: 3 0 0 56)
					)
				)
			)
			(2
				(if script
					(self setScript: 0 setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(6 (Hippocrates init: 1 0 0 12))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (cue)
		(if
		(and (proc819_3 38) (not ((Inv at: 34) owner?)))
			(Hippocrates init: 1 0 0 3 1)
		else
			(global2 setScript: firstTalk)
		)
	)
)

(instance bubble of EcoView
	(properties
		x 21
		y 3
		view 243
		priority 15
		signal $4010
	)
)

(instance bubbleFish of EcoProp
	(properties
		x 102
		y 5
		view 243
		loop 1
		priority 15
		signal $4010
		cycleSpeed 13
	)
)

(instance tools of EcoView
	(properties
		x 118
		y 86
		onMeCheck $0000
		view 226
		loop 3
		cel 1
		signal $4011
	)
)

(instance rings of EcoProp
	(properties
		x 176
		y 90
		approachX 144
		approachY 101
		view 238
		loop 5
		signal $4010
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 6)
		(= signal (& signal $efff))
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 67))
			(4
				(global2 setScript: pickupRings 0 theVerb)
			)
			(6
				(global2 setScript: pickupRings 0 theVerb)
			)
			(44
				(switch temp0
					(17
						(EcoNarrator init: 3 0 0 69)
					)
					(else 
						(EcoNarrator init: 3 0 0 70)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (cue)
		(self stopUpd: setPri: 0)
	)
)

(instance golfClubs of EcoFeature
	(properties
		x 253
		y 74
		nsTop 57
		nsLeft 247
		nsBottom 92
		nsRight 260
		sightAngle 90
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 57))
			(4 (EcoNarrator init: 3 0 0 16))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance bookCase of EcoFeature
	(properties
		x 271
		y 69
		sightAngle 90
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 58))
			(4 (EcoNarrator init: 3 0 0 15))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (onMe param1)
		(if
			(or
				(proc999_4 263 45 280 94 param1)
				(proc999_4 281 44 290 59 param1)
			)
		else
			(proc999_4 299 45 310 60 param1)
		)
	)
)

(instance plant1 of EcoView
	(properties
		x 61
		y 89
		view 226
		priority 1
		signal $5011
		lookStr 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 19))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant2 of EcoView
	(properties
		x 281
		y 56
		z -75
		view 226
		loop 1
		signal $5011
		lookStr 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 19))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wallplaque of EcoView
	(properties
		x 230
		y 61
		view 226
		cel 2
		signal $5011
		lookStr 62
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
			(4 (EcoNarrator init: 3 0 0 71))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant of EcoView
	(properties
		x 165
		y 60
		view 220
		cel 2
		signal $5011
		lookStr 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 19))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance cert of EcoView
	(properties
		x 113
		y 67
		view 226
		cel 1
		signal $5011
		lookStr 61
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
			(4 (EcoNarrator init: 3 0 0 17))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance cabinet of EcoView
	(properties
		x 122
		y 118
		view 226
		loop 1
		cel 1
		signal $5011
		lookStr 60
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
			(1 (EcoNarrator init: 3 0 0 60))
			(4
				(if (proc819_5 50)
					(EcoNarrator init: 3 0 0 13)
				else
					(EcoNarrator init: 3 0 0 64)
				)
			)
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance sculpture of EcoView
	(properties
		x 69
		y 141
		view 226
		loop 2
		cel 1
		priority 10
		signal $5011
		lookStr 59
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
			(4 (EcoNarrator init: 3 0 0 18))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance anotherplant of EcoView
	(properties
		x 164
		y 171
		view 226
		loop 2
		priority 1
		signal $5011
		lookStr 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 19))
			(44
				(EcoNarrator init: 3 0 0 73)
			)
			(6 (EcoNarrator init: 3 0 0 72))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Hippocrates of EcoTalker
	(properties
		nsTop 95
		nsLeft 5
		view 235
		charNum 12
		keepWindow 1
	)
	
	(method (init)
		(if (= cel (!= ((Inv at: 34) owner?) 223))
			(hMouth nsLeft: 14 nsTop: 15)
		else
			(hMouth nsLeft: 19 nsTop: 10)
		)
		(hMouth loop: (+ 1 cel))
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
		nsTop 15
		nsLeft 14
		view 235
		loop 1
		cycleSpeed 10
	)
)
