;;; Sierra Script 1.0 - (do not remove this comment)
(script# 381)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use n958)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm381 0
	dolphin 3
)

(instance rm381 of EcoRoom
	(properties
		picture 901
		style $8009
		east 320
	)
	
	(method (init)
		(proc958_0 128 380 841 813)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						4
						83
						14
						81
						33
						76
						57
						75
						83
						73
						103
						76
						116
						82
						136
						87
						159
						93
						190
						103
						220
						113
						260
						127
						281
						113
						228
						103
						179
						88
						179
						82
						123
						64
						107
						62
						101
						58
						34
						58
						4
						68
					yourself:
				)
				((Polygon new:)
					type: 3
					init: 315 117 264 139 319 158 319 119
					yourself:
				)
		)
		(gFeatures
			add:
				bucket
				ladder
				panel
				fishNet
				cabinet
				cages
				boats
				garageDoor
				net
				wall
				lowerWall
				mat
				dock
				water
				safeArea
				pool
				poolFloor
				safeFood
				blackBoard
				starFish
			eachElementDo: #init
		)
		(proc819_3 70)
		(super init: &rest)
		(self picture: 380)
		(cond 
			((== gSouth 400) (self setScript: fromLab))
			((== gSouth 380) (self setScript: startUp))
			(else (self setScript: fromOcean))
		)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script 0)
			((>= (gEgo x?) 315)
				(if (not (gEgo has: 19))
					(self setScript: warnEgo)
				else
					(self setScript: leaveRoom)
				)
			)
		)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 380)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator posn: 160 20 init: 5 0 0 1 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (notify)
		(self setScript: leaveRoom)
	)
)

(instance delphBackDrop of EcoView
	(properties
		x 113
		y 73
		view 387
		loop 1
		priority 13
		signal $4010
	)
)

(instance outsideGate of EcoProp
	(properties
		x 245
		y 174
		view 396
		loop 1
		signal $4000
		lookStr 23
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dolphinLever of EcoProp
	(properties
		x 217
		y 145
		view 380
		loop 4
		signal $4000
		lookStr 55
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance labDoor of EcoProp
	(properties
		x 90
		y 56
		view 380
		signal $4000
		cycleSpeed 0
		lookStr 21
	)
	
	(method (init)
		(super init: &rest)
		(if (== gSouth 400) (self setCel: (self lastCel:)))
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc819_5 70))
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= temp0 theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(1
					(EcoNarrator init: 5 0 0 lookStr 0 380)
				)
				(4 (global2 setScript: toLab))
				(else 
					(super doVerb: theVerb temp0 &rest)
				)
			)
		else
			(EcoNarrator posn: 160 20 init: 5 0 0 69 0 380)
		)
	)
)

(instance dockDoor of EcoProp
	(properties
		x 292
		y 128
		z 60
		approachX 271
		approachY 138
		view 380
		loop 2
		priority 9
		signal $4010
		lookStr 22
	)
	
	(method (init)
		(super init: &rest)
		(if (== gSouth 400)
			(= approachX 250)
			(= approachY 118)
		)
		(self approachVerbs: 4)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(4
				(if (proc819_5 70)
					(global2 setScript: inDockDoor)
				else
					(global2 setScript: outDockDoor)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance outsideGateLever of EcoProp
	(properties
		x 212
		y 116
		approachX 204
		approachY 107
		view 380
		loop 3
		signal $4000
		lookStr 71
	)
	
	(method (init)
		(super init: &rest)
		(self setCel: (self lastCel:))
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(44
				(EcoNarrator posn: 160 20 init: 6 0 0 32 0 380)
			)
			(1
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance insideGate of EcoProp
	(properties
		x 144
		y 142
		view 396
		signal $4000
		lookStr 54
	)
	
	(method (init)
		(super init: &rest)
		(self setCel: (self lastCel:))
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bucket of EcoFeature
	(properties
		x 104
		y 55
		onMeCheck $0004
		approachX 104
		approachY 66
		lookStr 38
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				((ScriptID 2 1) init: 2 0 0 lookStr 1 0 380)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 lookStr 1 0 380)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ladder of EcoFeature
	(properties
		x 72
		y 42
		onMeCheck $0002
		approachX 87
		approachY 80
		lookStr 18
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance starFish of EcoFeature
	(properties
		x 234
		y 165
		nsTop 156
		nsLeft 204
		nsBottom 176
		nsRight 255
		onMeCheck $0100
		approachX 317
		approachY 136
		lookStr 56
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 160 20 init: 5 0 0 lookStr 0 380)
			)
			(4
				(EcoNarrator posn: 160 20 init: 5 0 0 lookStr 0 380)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance panel of EcoFeature
	(properties
		x 6
		y 46
		nsTop 36
		nsBottom 68
		nsRight 20
		onMeCheck $4000
		approachX 10
		approachY 69
		lookStr 12
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator posn: 160 20 init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fishNet of EcoFeature
	(properties
		x 29
		y 16
		nsTop 2
		nsLeft 21
		nsBottom 60
		nsRight 37
		onMeCheck $4000
		approachX 27
		approachY 66
		lookStr 15
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cabinet of EcoFeature
	(properties
		x 152
		y 52
		nsTop 39
		nsLeft 130
		nsBottom 76
		nsRight 186
		onMeCheck $2000
		approachX 135
		approachY 74
		lookStr 62
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc819_5 70))
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= temp0 theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(1
					(EcoNarrator posn: 160 20 init: 5 0 0 lookStr 0 380)
				)
				(4
					(if (gEgo has: 19)
						(EcoNarrator posn: 160 20 init: 5 0 0 60 0 380)
					else
						(global2 setScript: (ScriptID 67 0))
					)
				)
				(else 
					(super doVerb: theVerb temp0 &rest)
				)
			)
		else
			(EcoNarrator posn: 160 20 init: 5 0 0 69 0 380)
		)
	)
)

(instance cages of EcoFeature
	(properties
		x 218
		y 74
		nsTop 78
		nsLeft 188
		nsBottom 102
		nsRight 235
		onMeCheck $4000
		approachX 201
		approachY 99
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc819_5 70))
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= temp0 theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(1
					(global2 setScript: (ScriptID 69 1) 0 -1)
				)
				(4
					(global2 setScript: (ScriptID 69 1) 0 -1)
				)
				(else 
					(super doVerb: theVerb temp0 &rest)
				)
			)
		else
			(EcoNarrator posn: 160 20 init: 5 0 0 69 0 380)
		)
	)
)

(instance boats of EcoFeature
	(properties
		x 228
		y 59
		nsTop 13
		nsLeft 191
		nsBottom 103
		nsRight 279
		onMeCheck $2000
		approachX 201
		approachY 99
		lookStr 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(4
				(EcoNarrator init: 5 0 0 2 0 380)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance garageDoor of EcoFeature
	(properties
		x 228
		y 59
		nsLeft 209
		nsBottom 48
		nsRight 294
		onMeCheck $1000
		approachX 201
		approachY 99
		lookStr 63
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance net of EcoFeature
	(properties
		x 127
		y 149
		nsTop 104
		nsLeft 39
		nsBottom 189
		nsRight 205
		onMeCheck $1000
		approachX 176
		approachY 93
		lookStr 64
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wall of EcoFeature
	(properties
		x 222
		y 148
		nsLeft 125
		nsBottom 189
		nsRight 319
		onMeCheck $0800
		approachX 227
		approachY 107
		lookStr 65
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lowerWall of EcoFeature
	(properties
		nsTop 149
		nsLeft 177
		nsBottom 149
		nsRight 265
		onMeCheck $0400
		approachX 227
		approachY 107
		lookStr 66
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mat of EcoFeature
	(properties
		x 297
		y 125
		nsTop 117
		nsLeft 274
		nsBottom 138
		nsRight 317
		onMeCheck $4000
		approachX 313
		approachY 133
		lookStr 67
	)
	
	(method (init)
		(super init:)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (User controls?)
			(if
				(and
					(not (global2 script?))
					(!= (pEvent type?) evVERB)
					(self onMe: pEvent)
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
					(not (pEvent modifiers?))
					(== (gIconBar curIcon?) (gIconBar at: 0))
				)
				(if (not (proc819_5 70))
					(if (not (proc819_5 113))
						(pEvent claimed: 1)
						(dockDoor doVerb: 4)
					else
						(pEvent claimed: 1)
						(ladder doVerb: 4)
					)
				else
					(super handleEvent: pEvent &rest)
				)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance blackBoard of EcoFeature
	(properties
		x 140
		y 37
		nsTop 2
		nsLeft 130
		nsBottom 49
		nsRight 196
		sightAngle 45
		onMeCheck $4000
		approachX 135
		approachY 74
	)
	
	(method (doVerb theVerb)
		(if (not (proc819_5 70))
			(switch theVerb
				(1
					(global2 setScript: (ScriptID 69 0) 0 -1)
				)
				(4
					(global2 setScript: (ScriptID 69 0) 0 -1)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		else
			(EcoNarrator posn: 160 20 init: 5 0 0 69 0 380)
		)
	)
)

(instance safeFood of EcoFeature
	(properties
		x 201
		y 127
		nsTop 117
		nsLeft 186
		nsBottom 135
		nsRight 221
		sightAngle 45
		onMeCheck $2000
		lookStr 70
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 160 20 init: 5 0 0 lookStr 0 380)
			)
			(4
				(EcoNarrator posn: 160 20 init: 5 0 0 58 0 380)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dock of EcoFeature
	(properties
		x 315
		y 139
		nsTop 109
		nsLeft 248
		nsBottom 169
		nsRight 319
		onMeCheck $1000
		approachX 271
		approachY 138
		lookStr 25
	)
	
	(method (init)
		(super init:)
		(if (== gSouth 400)
			(= approachX 250)
			(= approachY 118)
		)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (User controls?)
			(if
				(and
					(not (global2 script?))
					(!= (pEvent type?) evVERB)
					(self onMe: pEvent)
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
					(not (pEvent modifiers?))
					(== (gIconBar curIcon?) (gIconBar at: 0))
				)
				(if (not (proc819_5 70))
					(if (not (proc819_5 113))
						(pEvent claimed: 1)
						(dockDoor doVerb: 4)
					else
						(pEvent claimed: 1)
						(ladder doVerb: 4)
					)
				else
					(super handleEvent: pEvent &rest)
				)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(4
				(EcoNarrator init: 5 0 0 27 0 380)
			)
			(2 (dolphin doVerb: 2))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poolFloor of EcoFeature
	(properties
		x 104
		y 55
		sightAngle 45
		onMeCheck $0040
	)
	
	(method (init)
		(super init:)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (User controls?)
			(if
				(and
					(not (global2 script?))
					(!= (pEvent type?) evVERB)
					(self onMe: pEvent)
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
					(== (gIconBar curIcon?) (gIconBar at: 0))
					(proc819_5 70)
				)
				(pEvent claimed: 1)
				(dockDoor doVerb: 4)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb)
		(global2 doVerb: &rest)
	)
)

(instance water of EcoFeature
	(properties
		nsTop 150
		nsLeft 266
		nsBottom 189
		nsRight 319
		onMeCheck $4000
		approachX 313
		approachY 133
		lookStr 30
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance safeArea of EcoFeature
	(properties
		x 158
		y 159
		nsTop 120
		nsLeft 62
		nsBottom 189
		nsRight 227
		onMeCheck $0200
		approachX 228
		approachY 109
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dolphin of EcoActor
	(properties
		x 160
		y 97
		modNum 380
		view 387
		loop 7
		priority 14
		signal $4010
		cycleSpeed 12
		lookStr 68
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator init: 5 0 0 lookStr 0 380)
			)
			(2
				((ScriptID 2 0) init: 1 0 0 33 1 0 380)
			)
			(44
				((ScriptID 2 0) init: 1 0 0 36 1 0 380)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance pool of EcoFeature
	(properties
		x 67
		y 117
		nsTop 83
		nsBottom 189
		nsRight 188
		onMeCheck $0100
		approachX 62
		approachY 66
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 1)
			(EcoNarrator init: 5 0 0 lookStr 0 380)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tFrisbee of EcoView
	(properties
		z 100
		view 380
		loop 5
		priority 1
		signal $4011
	)
	
	(method (init)
		(self x: global120 y: global121)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator posn: 160 20 init: 5 0 0 96 0 380)
			)
			(4
				(EcoNarrator posn: 160 20 init: 6 0 0 16 0 380)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance startUp of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 250])
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_3 106)
				(= cycles 1)
			)
			(1
				(Message msgGET 380 5 0 2 11 @temp0)
				(= register
					(Display
						@temp0
						dsCOORD
						135
						85
						dsCOLOR
						gInnerBordColor
						dsFONT
						6
						dsSAVEPIXELS
					)
				)
				(= seconds 7)
			)
			(2
				(Display {} dsRESTOREPIXELS register)
				(outsideGate init: stopUpd:)
				(dolphinLever init: stopUpd:)
				(labDoor init: stopUpd:)
				(dockDoor init: stopUpd:)
				(outsideGateLever init: stopUpd:)
				(insideGate init: stopUpd:)
				(global2 drawPic: 380)
				(gLongSong2 number: 391 loop: -1 play:)
				(gEgo
					view: 387
					init:
					loop: 0
					cel: 0
					setPri: -1
					posn: 288 146
					cycleSpeed: 20
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(3
				(EcoNarrator init: 5 0 0 84 self 380)
			)
			(4
				(delphBackDrop init:)
				(= seconds 2)
			)
			(5
				(returningSound
					number: 383
					loop: -1
					play: 37
					fade: 52 40 5 0
				)
				(dolphin init: setCycle: End)
				(= seconds 2)
			)
			(6
				(returningSound fade: 67 40 5 0)
				(dolphin loop: 6 cel: 0 posn: 160 99 setCycle: End)
				(= seconds 2)
			)
			(7
				(returningSound fade: 82 40 5 0)
				(dolphin loop: 5 cel: 0 posn: 160 101 setCycle: End)
				(= seconds 2)
			)
			(8
				(returningSound fade: 97 40 5 0)
				(dolphin loop: 4 cel: 0 posn: 160 105 setCycle: End)
				(= seconds 2)
			)
			(9
				(returningSound fade: 112 40 5 0)
				(dolphin loop: 3 cel: 0 posn: 146 112 setCycle: End)
				(= seconds 2)
			)
			(10
				(returningSound fade: 127 40 5 0)
				(dolphin loop: 2 cel: 0 posn: 174 114 setCycle: End)
				(= seconds 2)
			)
			(11
				(dolphin loop: 8 cel: 0 posn: 158 136 setCycle: End self)
			)
			(12
				(gSoundEffects number: 916 loop: 1 play:)
				(= seconds 2)
			)
			(13
				(returningSound fade:)
				(gLongSong number: 386 loop: -1 play:)
				(dolphin
					view: 382
					loop: 6
					cel: 0
					posn: 285 283 100
					setCycle: Fwd
					cycleSpeed: 20
				)
				(delphBackDrop dispose:)
				(gEgo loop: 9 cel: 0 setCycle: End self)
			)
			(14
				((ScriptID 2 1) init: 2 0 0 11 0 self 380)
			)
			(15
				((ScriptID 2 1) init: 2 0 0 12 1 self 380)
			)
			(16
				((ScriptID 2 0) init: 1 0 0 17 1 self 380)
			)
			(17
				((ScriptID 2 1) init: 2 0 0 13 1 self 380)
			)
			(18
				((ScriptID 2 0) init: 1 0 0 18 1 self 380)
			)
			(19
				((ScriptID 2 1) init: 2 0 0 14 1 self 380)
			)
			(20
				((ScriptID 2 0) init: 1 0 0 19 1 self 380)
			)
			(21
				(if (gEgo has: 19)
					((ScriptID 2 1) init: 2 0 0 15 1 self 380)
				else
					((ScriptID 2 0) init: 1 0 0 21 1 self 380)
				)
			)
			(22
				(if (gEgo has: 19)
					((ScriptID 2 0) init: 1 0 0 20 1 self 380)
				else
					(= ticks 3)
				)
			)
			(23
				(proc819_6 5)
				(gEgo
					posn: 279 149
					setPri: 10
					setMotion: MoveTo 294 142 self
				)
			)
			(24
				(proc0_2)
				(gIconBar enable: 7)
				(self dispose:)
			)
		)
	)
)

(instance inDockDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(dockDoor approachX: 250 approachY: 118)
				(proc819_4 70)
				(gEgo setMotion: PolyPath 272 131 self)
			)
			(1 (gEgo setHeading: 0 self))
			(2
				(gEgo view: 380 loop: 7 cel: 0 setCycle: CT 1 1 self)
				(gSoundEffects number: 901 loop: 1 play:)
				(dockDoor startUpd: setCel: 1)
			)
			(3
				(gEgo setCel: 2)
				(dockDoor setCel: 2)
				(= cycles 1)
			)
			(4
				(proc819_6 3)
				(dockDoor setCycle: End self)
			)
			(5
				(gEgo setMotion: MoveTo 289 130 self)
			)
			(6
				(gEgo setPri: -1 setMotion: MoveTo 236 110 self)
			)
			(7
				(gLongSong2 fade: 0 10 25 1)
				(dockDoor setCycle: Beg self)
			)
			(8
				(gSoundEffects number: 902 loop: 1 play:)
				(dockDoor stopUpd:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance outDockDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dockDoor approachX: 271 approachY: 138)
				(proc0_1)
				(gEgo setMotion: PolyPath 250 118 self)
			)
			(1
				(proc819_3 70)
				(gSoundEffects number: 901 loop: 1 play:)
				(gLongSong2
					number: 391
					loop: -1
					play: 0
					fade: 127 10 25 0
				)
				(dockDoor startUpd: setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 307 136 self)
			)
			(3
				(gEgo setPri: 11)
				(dockDoor setCycle: Beg self)
			)
			(4
				(dockDoor stopUpd:)
				(gSoundEffects number: 902 loop: 1 play:)
				(if (== client global2) (proc0_2))
				(self dispose:)
			)
		)
	)
)

(instance toLab of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 53 63 self)
			)
			(1 (gEgo setHeading: 45 self))
			(2
				(gSoundEffects number: 901 loop: 1 play:)
				(gEgo view: 380 loop: 6 cel: 0 setCycle: CT 1 1 self)
				(labDoor startUpd: setCel: 1)
			)
			(3
				(gEgo setCel: 2)
				(labDoor setCel: 2)
				(= cycles 1)
			)
			(4
				(labDoor setCycle: End)
				(proc819_6 6)
				(gEgo setMotion: MoveTo 73 61 self)
			)
			(5
				(gEgo setMotion: MoveTo 73 41 self)
			)
			(6
				(labDoor stopUpd:)
				(global2 newRoom: 400)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance warnEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 0) init: 1 0 0 21 1 self 380)
			)
			(1
				(gEgo setMotion: MoveTo 298 134 self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance fromOcean of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(outsideGate init: stopUpd:)
				(dolphinLever init: stopUpd:)
				(labDoor init: stopUpd:)
				(dockDoor init: stopUpd:)
				(outsideGateLever init: stopUpd:)
				(insideGate init: stopUpd:)
				(global2 drawPic: 380)
				(gEgo init: get: 17 posn: 334 141)
				(dolphin
					view: 382
					loop: 6
					init:
					cel: 0
					posn: 285 283 100
					setCycle: Fwd
					cycleSpeed: 20
				)
				(proc819_6 7)
				(proc819_3 70)
				(= cycles 1)
			)
			(1
				(self setScript: takeGearOff self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance fromLab of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(outsideGate init: stopUpd:)
				(dolphinLever init: stopUpd:)
				(labDoor init: stopUpd:)
				(dockDoor init: stopUpd:)
				(outsideGateLever init: stopUpd:)
				(insideGate init: stopUpd:)
				(global2 drawPic: 380)
				(gEgo init: posn: 73 71)
				(proc819_6 2)
				(proc819_4 70)
				(dolphin
					view: 382
					loop: 6
					init:
					cel: 0
					posn: 285 183
					setCycle: Fwd
					cycleSpeed: 20
				)
				(gLongSong number: 386 loop: -1 play:)
				(= cycles 2)
			)
			(1
				(labDoor startUpd: setCycle: Beg self)
			)
			(2
				(gSoundEffects number: 902 loop: 1 play:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc0_4 5 242)
				(if (gEgo has: 10) (proc819_3 214))
				(gEgo
					put: 10
					put: 11
					put: 12
					put: 33
					put: 18
					put: 15 360
					put: 16
					put: 14
					put: 17
				)
				(if (not (proc819_5 70))
					(self setScript: outDockDoor self)
				else
					(= ticks 3)
				)
			)
			(1
				(EcoNarrator init: 6 0 0 18 self 380)
			)
			(2
				(self setScript: getGearOn self)
			)
			(3
				(global2 newRoom: 320)
				(self dispose:)
			)
		)
	)
)

(instance getGearOn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 298 154 self)
			)
			(1
				(gEgo
					view: 387
					loop: 9
					cel: 6
					cycleSpeed: 15
					setCycle: Beg self
				)
			)
			(2
				(gEgo view: 376 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo view: 376 loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo view: 376 loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(gEgo view: 376 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(gEgo
					view: 376
					loop: 4
					cel: 0
					posn: 275 141
					setCycle: CT 6 1 self
				)
			)
			(7
				(gSoundEffects number: 398 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(8 (gEgo hide:) (= cycles 2))
			(9
				(EcoNarrator init: 6 0 0 30 self 380)
			)
			(10 (self dispose:))
		)
	)
)

(instance takeGearOff of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 376
					setLoop: 5
					cel: 0
					setCycle: Walk
					posn: 334 153
					setMotion: MoveTo 298 154 self
				)
			)
			(1
				(gEgo
					cycleSpeed: 15
					setLoop: -1
					loop: 0
					cel: 6
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 376
					loop: 3
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(3
				(gEgo
					view: 376
					loop: 2
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(4
				(gEgo
					view: 376
					loop: 1
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(5
				(gEgo view: 387 loop: 9 cel: 0 setCycle: End self)
			)
			(6
				(proc819_6 5)
				(gEgo
					posn: 288 146
					setPri: 11
					setMotion: MoveTo 298 134 self
				)
			)
			(7 (self dispose:))
		)
	)
)

(instance returningSound of Sound
	(properties)
)
