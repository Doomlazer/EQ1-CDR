;;; Sierra Script 1.0 - (do not remove this comment)
(script# 200)
(include sci.sh)
(use Main)
(use n804)
(use HandsOffScript)
(use EcoRoom)
(use Garbage)
(use Apartment)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use ForwardCounter)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm200 0
	enterApartment 1
	Gregarious 3
	gregEnter 4
	gregExit 5
	narci 6
	gregarious 7
	talkIntoApt 8
	gregariousA 9
)

(local
	local0
	local1
	local2
)
(procedure (localproc_25cb param1 param2)
	(= local0 param1)
	(= local1 param2)
)

(instance rm200 of EcoRoom
	(properties
		picture 200
		style $000a
		horizon 16
		east 120
		south 180
	)
	
	(method (init &tmp gEgoX)
		(= global250 4)
		(= global251 1)
		(if (proc819_5 43) (= north 341))
		(proc819_4 107)
		(if (== gSouth 180)
			(= gEgoX (gEgo x?))
			(gEgo x: (proc999_2 219 gEgoX))
		)
		(super init:)
		(if (not (proc819_5 345))
			(gCast
				add: cap candyBox shoe tube sock plate shirt toaster2 book
				eachElementDo: #init
			)
		)
		(gFeatures
			add:
				blowFishA
				emptyNestA3
				lionFishA
				emptyA1
				swordFishA
				gregariousA
				angelFishA
				emptyNestA2
				seaTurtleA
				columns
				buildings
				steps
				pipes
				moss
				vegatation
			eachElementDo: #init
		)
		(if (proc819_5 46) (pump init: setPri: 1))
		(if (not (gEgo has: 33)) (wetRag init:))
		(if (proc819_5 66) (brokenBottle init:))
		(if (proc819_5 65) (sandwich init:))
		(if (proc819_5 47)
			(narci
				view: 223
				loop: 4
				cel: 0
				x: 84
				y: 70
				cycleSpeed: 4
				setCycle: Fwd
				init:
			)
		)
		(plant1 setCycle: Fwd init:)
		(plant2 setCycle: Fwd init:)
		(plant3 setCycle: Fwd init:)
		(proc819_6 1)
		(gEgo
			init:
			heading: 270
			setPri: 6
			illegalBits: 0
			ignoreHorizon:
			hide:
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 265 189 297 178 319 178 319 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 189 0 0 319 0 319 5 7 5 7 189
					yourself:
				)
			setRegions: 51
		)
		(cond 
			(
				(and
					(gEgo has: 21)
					(not (proc819_5 60))
					(== ((Inv at: 0) owner?) 335)
				)
				(proc819_3 60)
				(global2 setScript: goToCouncilChambers)
			)
			((== gSouth 341)
				(if (== ((Inv at: 0) owner?) 335)
					(global2 setScript: manateeDone)
				else
					(gEgo posn: 211 -18)
					(self setScript: enterFromBoat)
				)
			)
			((proc819_5 40) (global2 setScript: swimThru))
			((proc999_5 gSouth 220 221 222 223 224 225 226)
				(self
					setScript:
						exitApartment
						0
						(switch gBelongsTo
							(1 angelFishA)
							(2 emptyA1)
							(3 gregariousA)
							(4 emptyNestA2)
							(5 swordFishA)
							(6 blowFishA)
							(7 lionFishA)
							(8 emptyNestA3)
							(9 seaTurtleA)
						)
				)
			)
			((== gSouth 120) (gEgo posn: 370 143) (localproc_25cb 277 139))
			(else
				(gEgo posn: (gEgo x?) 220)
				(localproc_25cb (gEgo x?) 175)
			)
		)
		(if local0 (self setScript: enterScript))
		(gLongSong number: 217 loop: -1 play:)
	)
	
	(method (doit &tmp gEgoEdgeHit)
		(Palette palANIMATE 33 43 7)
		(= gEgoEdgeHit (gEgo edgeHit?))
		(cond 
			(script 0)
			(
				(or
					(and (== gEgoEdgeHit 1) (not north))
					(== gEgoEdgeHit 4)
				)
				(global2 setScript: cantLeave)
			)
			(
				(and
					(> (gEgo x?) 219)
					(or (== gEgoEdgeHit 3) (== gEgoEdgeHit 2))
				)
				(global2 setScript: exitToCourtYard)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(gDelph lookStr: 0 talkScript: 0)
		(proc819_4 107)
		(gEgo setPri: -1)
		(super dispose:)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 13))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterFromBoat of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 2))
			(1
				(gEgo show: setMotion: MoveTo (gEgo x?) 28 self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1
				(gEgo show: setMotion: MoveTo local0 local1 self)
			)
			(2
				(= local0 (= local1 0))
				(if
					(and
						(!= ((Inv at: 1) owner?) 200)
						(not (proc819_5 5))
					)
					(plant1 setScript: (ScriptID 201 0))
					(self dispose:)
				else
					(proc0_2)
					(self dispose:)
				)
			)
		)
	)
)

(instance exitToCourtYard of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== state 0)
				(or (> (gEgo nsLeft?) 320) (> (gEgo nsTop?) 190))
			)
			(= cycles 1)
		)
	)
	
	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo
					ignoreActors: 1
					setCycle: Walk
					setHeading: 135
					setMotion: MoveFwd 200
				)
			)
			(1 (global2 newRoom: 120))
		)
	)
)

(instance enterApartment of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_9
					gEgo
					(register swimX?)
					(register swimY?)
					self
				)
			)
			(1
				(gEgo setCycle: 0 view: 814 setLoop: (gEgo loop?))
				(= cycles 3)
			)
			(2
				(gEgo
					view: 802
					setCycle: Walk
					setMotion: MoveTo (register swimX?) (register swimY?) self
				)
			)
			(3
				(global2 newRoom: (register newRoom:))
			)
		)
	)
)

(instance exitApartment of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1
				(gEgo
					setCycle: 0
					view: 802
					setCycle: Walk
					setLoop: 0
					show:
					ignoreHorizon:
					setPri: (register egoPri?)
					posn: (register swimX?) (register swimY?)
				)
				(= cycles 3)
			)
			(2
				(gEgo
					setMotion: MoveTo (register approachX?) (register approachY?) self
				)
			)
			(3
				(if
					(and
						(!= (register bitValue?) -32768)
						(not (register IamHome?))
						(not (& global119 (register bitValue?)))
					)
					(= global119 (| global119 (register bitValue?)))
					(EcoNarrator init: 4 0 0 (register lightMsg?) self)
				else
					(= cycles 1)
				)
			)
			(4
				(proc819_6 0)
				(gEgo setPri: 6)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance gregExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gregarious
					view: (if (proc819_5 299) 253 else 244)
					loop: 0
					cel: 0
					posn: 168 97
					cycleSpeed: 12
					init:
					setCycle: End self
				)
			)
			(1
				(gregarious
					view: (if (proc819_5 299) 252 else 231)
					loop: 0
					cel: 0
				)
				(= cycles 2)
			)
			(2
				(proc819_9 (ScriptID 200 7) gEgo self)
			)
			(3 (= seconds 2))
			(4 (self dispose:))
		)
	)
)

(instance gregEnter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gregarious
					view: (if (proc819_5 299) 253 else 244)
					loop: 0
					cel: 1
					posn: 168 97
					cycleSpeed: 15
					init:
					setCycle: Beg self
				)
			)
			(1
				(gregarious dispose:)
				(= cycles 2)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance cantLeave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(if
					(and
						(== ((Inv at: 0) owner?) 335)
						(== (gEgo edgeHit?) 1)
					)
					(EcoNarrator init: 4 0 0 18 self)
				else
					(EcoNarrator init: 4 0 0 6 self)
				)
			)
			(1
				(if (== (gEgo edgeHit?) 1)
					(gEgo setMotion: MoveTo (gEgo x?) 26 self)
				else
					(gEgo setMotion: MoveTo 25 (gEgo y?) self)
				)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance swimThru of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= seconds 2))
			(1
				(gregarious
					view: 244
					loop: 0
					cel: 0
					posn: 168 97
					yStep: 4
					cycleSpeed: 8
					illegalBits: 0
					ignoreActors: 1
					setCycle: End self
					init:
				)
			)
			(2
				(gEgo
					posn: 100 113
					setPri: 1
					illegalBits: 0
					setCycle: Walk
					init:
				)
				(gregarious view: 231 cel: 0 posn: 168 99 setPri: 4)
				(= cycles 5)
			)
			(3
				(gregarious
					view: 231
					cel: 0
					posn: 170 94
					setCycle: Walk
					setMotion: MoveTo 145 -30
				)
				(= seconds 2)
			)
			(4
				(EcoNarrator init: 4 0 0 16 self)
			)
			(5
				(gEgo show: setMotion: MoveTo 174 104 self)
			)
			(6
				(gEgo setPri: 6 setMotion: MoveTo 183 -23 self)
			)
			(7
				(proc0_2)
				(global2 newRoom: 341)
			)
		)
	)
)

(instance goToCouncilChambers of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(if (== gSouth 226)
					(gEgo show: posn: -20 25 setMotion: MoveTo 50 30 self)
				else
					(gregarious view: 252 loop: 0 cel: 0 posn: 168 97 init:)
					(gEgo
						posn: 160 -23
						setHeading: 180
						setPri: 6
						show:
						setMotion: MoveTo 160 40 self
					)
				)
			)
			(1
				((gregariousA light?) loop: 8 setCycle: 0)
				(= seconds 3)
			)
			(2
				(if (== gSouth 226)
					(gregarious setScript: gregExit self)
				else
					(= cycles 1)
				)
			)
			(3
				(if (== gSouth 226)
					(gregarious setHeading: 270 self)
				else
					(gregarious setHeading: 0 self)
				)
			)
			(4
				(Gregarious init: 1 0 0 1 1 self)
			)
			(5
				(gregarious
					setPri: 4
					ignoreActors: 1
					setCycle: Walk
					setMotion: PolyPath 296 138 self
				)
			)
			(6
				(gregarious setMotion: PolyPath 345 140 self)
				(gEgo setMotion: PolyPath 345 140 self)
			)
			(7
				(proc0_2)
				(global2 newRoom: 160)
			)
		)
	)
)

(instance talkIntoApt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 20 1 self)
			)
			(1
				(EcoNarrator init: 4 0 0 86 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance fallIntoNarcisApt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 158 87 self)
			)
			(1
				(gEgo looper: 0 setCycle: 0 setHeading: 280 self)
			)
			(2
				(gEgo
					setCycle: 0
					view: 201
					loop: 0
					cel: 0
					x: 125
					y: 85
					setCycle: End self
				)
			)
			(3
				(EcoNarrator init: 4 0 0 17 self)
			)
			(4
				(narci dispose:)
				(gEgo
					view: 201
					loop: 1
					cel: 0
					x: 102
					y: 80
					cycleSpeed: 10
					setCycle: ForwardCounter 3 self
				)
			)
			(5
				(proc0_4 5 279)
				(gEgo
					view: 201
					loop: 2
					cel: 0
					x: 102
					y: 80
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(6 (gEgo hide:) (= cycles 2))
			(7
				(proc0_2)
				(global2 newRoom: 221)
			)
		)
	)
)

(instance manateeDone of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gregarious view: 252 loop: 0 cel: 0 posn: 168 97 init:)
				(gEgo
					show:
					posn: 160 -20
					setPri: 6
					setMotion: MoveTo 160 40 self
				)
			)
			(1 (= cycles 10))
			(2
				(Gregarious init: 1 0 0 10 1 self)
			)
			(3
				((ScriptID 2 1) init: 2 0 0 15 1 self)
			)
			(4
				(if (gEgo has: 21) (= state 7))
				(= cycles 1)
			)
			(5
				(Gregarious init: 1 0 0 11 1 self)
			)
			(6
				((ScriptID 2 1) init: 2 0 0 16 1 self)
			)
			(7 (= state 9) (= cycles 1))
			(8
				(Gregarious init: 1 0 0 22 self)
			)
			(9
				(Gregarious init: 1 0 0 23 self)
			)
			(10
				(gregarious
					view: 253
					loop: 0
					cel: 1
					posn: 168 97
					cycleSpeed: 12
					setCycle: Beg self
				)
			)
			(11
				(gregarious dispose:)
				(proc819_6)
				(gEgo illegalBits: 0 setPri: 6 ignoreHorizon:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance getPump of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 41 129 self)
			)
			(1 (= cycles 15))
			(2
				(gEgo
					setCycle: 0
					view: 200
					loop: 6
					cel: 0
					posn: 42 141
					cycleSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(3
				(gEgo get: 5)
				(proc0_4 2 276)
				(proc819_4 46)
				(pump dispose:)
				(gEgo
					view: 200
					loop: 6
					cel: 6
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(EcoNarrator init: 4 0 0 71 self)
			)
			(5
				(proc819_6)
				(gEgo
					posn: 68 131
					setPri: 6
					illegalBits: 0
					ignoreHorizon:
				)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance getWetRag of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 187 101 self)
			)
			(1 (gEgo setHeading: 180 self))
			(2
				(gEgo
					setCycle: 0
					view: 181
					loop: 4
					cel: 0
					posn: 189 121
					setPri: 15
					cycleSpeed: 10
					setCycle: CT 7 1 self
				)
			)
			(3
				(wetRag hide:)
				(gEgo setCycle: End self)
				(proc0_4 2 275)
			)
			(4
				(= global232 3)
				(gEgo get: 33)
				(proc819_6)
				(gEgo
					illegalBits: 0
					setPri: 6
					ignoreHorizon:
					posn: 186 128
					setHeading: 180 self
				)
			)
			(5
				(EcoNarrator init: 4 0 0 78 self)
			)
			(6 (self dispose:))
		)
	)
)

(instance acceptStarfish of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 202 99 self)
			)
			(1
				(gregarious
					view: 248
					loop: 1
					cel: 0
					posn: 167 95
					setCycle: CT 2 1
				)
				(gEgo
					view: 248
					loop: 0
					cel: 0
					posn: 196 87
					setCycle: End self
				)
			)
			(2
				(proc0_4 5 278)
				(gEgo put: 1 200)
				(proc819_6)
				(gEgo posn: 200 88)
				(= cycles 4)
			)
			(3
				(gregarious setCycle: End self)
			)
			(4
				(gregarious view: 231 loop: 4 cel: 0 posn: 167 95)
			)
			(5 (self dispose:))
		)
	)
)

(instance gregTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 4 0 0 72 self)
			)
			(1
				(= local2 (* (Random 6 9) 2))
				(Gregarious init: 1 0 0 local2 0 self)
			)
			(2
				(Gregarious init: 1 0 0 (+ local2 1) 1 self)
			)
			(3 (self dispose:))
		)
	)
)

(instance otherThanStarfish of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 22 1 self)
			)
			(1
				(Gregarious init: 1 0 0 21 1 self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance lookAtGreg of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 4 0 0 14 self)
			)
			(1
				(EcoNarrator init: 4 0 0 87 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance angelFishA of Apartment
	(properties
		onMeCheck $0002
		approachX 72
		approachY 95
		BelongsTo 1
		bitValue 16
		lightX 3
		lightY 90
		lightMsg 56
		swimX -30
		swimY 98
		egoPri 3
		newRoom 222
	)
	
	(method (init)
		(if (== ((Inv at: 8) owner?) 222) (= IamHome 1))
		(super init: porchLight &rest)
	)
)

(instance emptyNestA3 of Apartment
	(properties
		onMeCheck $0004
		approachX 136
		approachY 125
		BelongsTo 8
		bitValue -32768
		swimX 38
		swimY 116
		egoPri 2
		newRoom 220
	)
	
	(method (init)
		(super init: 0 &rest)
	)
)

(instance gregariousA of Apartment
	(properties
		onMeCheck $0008
		BelongsTo 3
		bitValue -32768
		lightX 166
		lightY 93
		swimX 102
		swimY 106
		egoPri 1
		newRoom 225
	)
	
	(method (init)
		(if (== ((Inv at: 2) owner?) 160) (= IamHome 1))
		(if (!= ((Inv at: 1) owner?) 200)
			(= approachX 200)
			(= approachY 88)
		else
			(= approachX 186)
			(= approachY 109)
		)
		(super init: porchLight &rest)
		(light setPri: 1)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 60)
					(EcoNarrator init: 4 0 0 98)
				else
					(EcoNarrator init: 4 0 0 11)
				)
			)
			(4
				(if (!= ((Inv at: 1) owner?) 200)
					(if (gCast contains: (ScriptID 200 7))
						(EcoNarrator init: 4 0 0 95)
					else
						(global2 setScript: (ScriptID 202 0))
					)
				else
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
			(44
				(cond 
					(
						(and
							(!= ((Inv at: 1) owner?) 200)
							(not (gCast contains: (ScriptID 200 7)))
						)
						(if (proc819_5 39)
							(EcoNarrator init: 4 0 0 92)
						else
							(EcoNarrator init: 4 0 0 93)
						)
					)
					((gCast contains: (ScriptID 200 7)) (EcoNarrator init: 4 0 0 95))
					((proc819_5 43) (EcoNarrator init: 4 0 0 89))
					((proc819_3 60) (EcoNarrator init: 4 0 0 98))
					(else (super doVerb: theVerb theTheVerb))
				)
			)
			(2
				(cond 
					((!= ((Inv at: 1) owner?) 200)
						(if (gCast contains: (ScriptID 200 7))
							(EcoNarrator init: 4 0 0 95)
						else
							((ScriptID 202 0) start: -1)
							(global2 setScript: (ScriptID 202 0))
							((ScriptID 2 1) init: 2 0 0 20 1 (ScriptID 202 0))
						)
					)
					((not (gEgo has: 25)) (EcoNarrator init: 4 0 0 89))
					(else (EcoNarrator init: 4 0 0 98))
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance emptyA1 of Apartment
	(properties
		onMeCheck $0010
		approachX 255
		approachY 104
		BelongsTo 2
		bitValue -32768
		swimX 170
		swimY 97
		newRoom 220
	)
	
	(method (init)
		(super init: 0 &rest)
	)
)

(instance swordFishA of Apartment
	(properties
		onMeCheck $0020
		approachX 209
		approachY 59
		BelongsTo 5
		bitValue 8
		lightX 183
		lightY 43
		lightMsg 55
		swimX 108
		swimY 59
		egoPri 1
		newRoom 223
	)
	
	(method (init)
		(if (== ((Inv at: 6) owner?) 223) (= IamHome 1))
		(super init: porchLight &rest)
		(light setPri: 1)
	)
)

(instance blowFishA of Apartment
	(properties
		onMeCheck $0040
		approachX 138
		approachY 71
		BelongsTo 6
		bitValue 1
		lightX 68
		lightY 64
		lightMsg 52
		swimX 41
		swimY 68
		egoPri 2
		newRoom 221
	)
	
	(method (init)
		(if (== ((Inv at: 7) owner?) 221) (= IamHome 1))
		(super init: porchLight &rest)
	)
	
	(method (doVerb theVerb)
		(if (proc819_5 47)
			(narci doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lionFishA of Apartment
	(properties
		onMeCheck $0080
		approachX 64
		approachY 35
		BelongsTo 7
		bitValue 2
		lightX 34
		lightY 15
		lightMsg 53
		swimX -52
		swimY 31
		egoPri 4
		newRoom 226
	)
	
	(method (init)
		(if (== ((Inv at: 21) owner?) 226) (= IamHome 1))
		(super init: porchLight &rest)
	)
)

(instance emptyNestA2 of Apartment
	(properties
		onMeCheck $0100
		approachX 116
		approachY 37
		BelongsTo 4
		bitValue -32768
		swimX 19
		swimY 34
		egoPri 3
		newRoom 220
	)
	
	(method (init)
		(super init: 0 &rest)
	)
)

(instance seaTurtleA of Apartment
	(properties
		onMeCheck $0200
		approachX 165
		approachY 32
		BelongsTo 9
		bitValue 4
		lightX 132
		lightY 19
		lightMsg 54
		swimX 66
		swimY 31
		egoPri 2
		newRoom 224
	)
	
	(method (init)
		(if (== ((Inv at: 4) owner?) 224) (= IamHome 1))
		(super init: porchLight &rest)
		(light setPri: 2)
	)
)

(instance columns of EcoFeature
	(properties
		onMeCheck $0400
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(= x ((User curEvent?) x?))
		(= y ((User curEvent?) y?))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 12))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance buildings of EcoFeature
	(properties
		onMeCheck $0800
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(= x ((User curEvent?) x?))
		(= y ((User curEvent?) y?))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 82))
			(4 (EcoNarrator init: 4 0 0 83))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance steps of EcoFeature
	(properties
		onMeCheck $1000
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 45))
			(4 (EcoNarrator init: 4 0 0 46))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance pipes of EcoFeature
	(properties
		onMeCheck $2000
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 80))
			(4 (EcoNarrator init: 4 0 0 81))
			(6 (EcoNarrator init: 4 0 0 81))
			(44
				(EcoNarrator init: 4 0 0 81)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance moss of EcoFeature
	(properties
		onMeCheck $4000
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 47))
			(4 (EcoNarrator init: 4 0 0 44))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance vegatation of EcoFeature
	(properties
		onMeCheck $8000
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 43))
			(4 (EcoNarrator init: 4 0 0 44))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance plant1 of EcoProp
	(properties
		x 186
		y 125
		view 200
		priority 1
		signal $4010
		cycleSpeed 10
		detailLevel 3
		lookStr 43
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 44))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance plant2 of EcoProp
	(properties
		x 40
		y 69
		view 200
		loop 1
		priority 4
		signal $4010
		cycleSpeed 8
		detailLevel 2
		lookStr 43
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 44))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance plant3 of EcoProp
	(properties
		x 197
		y 54
		view 200
		loop 2
		signal $4010
		cycleSpeed 14
		detailLevel 2
		lookStr 43
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 44))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance brokenBottle of Garbage
	(properties
		x 221
		y 158
		view 343
		loop 1
		cel 1
		flag 16
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 63))
			(4 (EcoNarrator init: 4 0 0 64))
			(6
				(EcoNarrator init: 4 0 0 65 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance candyBox of Garbage
	(properties
		x 265
		y 184
		view 200
		loop 3
		cel 1
		flag 17
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 37))
			(4 (EcoNarrator init: 4 0 0 38))
			(6
				(EcoNarrator init: 4 0 0 24 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance shoe of Garbage
	(properties
		x 10
		y 131
		approachX 50
		approachY 126
		view 200
		loop 3
		cel 2
		priority 3
		signal $4010
		flag 18
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 73))
			(4 (EcoNarrator init: 4 0 0 74))
			(6
				(EcoNarrator init: 4 0 0 75 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance tube of Garbage
	(properties
		x 268
		y 142
		view 200
		loop 3
		cel 3
		flag 19
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 29))
			(4 (EcoNarrator init: 4 0 0 30))
			(6
				(EcoNarrator init: 4 0 0 20 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance sock of Garbage
	(properties
		x 205
		y 69
		view 200
		loop 3
		cel 15
		priority 1
		signal $4010
		flag 20
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 33))
			(4 (EcoNarrator init: 4 0 0 34))
			(6
				(EcoNarrator init: 4 0 0 22 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance cap of Garbage
	(properties
		x 88
		y 142
		view 200
		loop 3
		cel 5
		flag 21
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 27))
			(4 (EcoNarrator init: 4 0 0 28))
			(6
				(EcoNarrator init: 4 0 0 19 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance plate of Garbage
	(properties
		x 215
		y 161
		view 200
		loop 3
		cel 6
		flag 22
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 39))
			(4 (EcoNarrator init: 4 0 0 40))
			(6
				(EcoNarrator init: 4 0 0 25 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance sandwich of Garbage
	(properties
		x 300
		y 137
		view 343
		loop 2
		cel 1
		flag 23
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 66))
			(4 (EcoNarrator init: 4 0 0 67))
			(6
				(proc819_4 65)
				(EcoNarrator init: 4 0 0 68 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance shirt of Garbage
	(properties
		x 168
		y 158
		view 200
		loop 3
		cel 9
		flag 24
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 41))
			(4 (EcoNarrator init: 4 0 0 42))
			(6
				(EcoNarrator init: 4 0 0 26 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance toaster2 of Garbage
	(properties
		x 166
		y 21
		approachX 168
		approachY 42
		view 200
		loop 3
		cel 11
		flag 25
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 31))
			(4 (EcoNarrator init: 4 0 0 32))
			(6
				(EcoNarrator init: 4 0 0 21 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance book of Garbage
	(properties
		x 230
		y 133
		view 200
		loop 3
		cel 4
		flag 8
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 35))
			(4 (EcoNarrator init: 4 0 0 36))
			(6
				(EcoNarrator init: 4 0 0 23 self)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance gregarious of EcoActor
	(properties
		x 146
		y 116
		approachX 200
		approachY 88
		yStep 3
		view 231
		loop 2
		priority 5
		signal $6010
		cycleSpeed 10
		illegalBits $0000
		xStep 5
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 9 1 2)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (self setScript: lookAtGreg))
			(2 (self setScript: gregTalk))
			(4
				(if (!= ((Inv at: 1) owner?) 200)
					(Gregarious init: 1 0 0 20 1)
				)
			)
			(44
				(switch theTheVerb
					(10
						(((global2 script?) script?) caller: 0)
						((global2 script?)
							setScript: (ScriptID 202 1) (global2 script?)
						)
					)
					(else 
						(global2 setScript: otherThanStarfish)
					)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance narci of EcoActor
	(properties
		x 103
		y 63
		view 223
		signal $4000
		cycleSpeed 15
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 57))
			(4
				(global2 setScript: fallIntoNarcisApt)
			)
			(2 (EcoNarrator init: 4 0 0 60))
			(44
				(switch theTheVerb
					(12
						(EcoNarrator init: 4 0 0 58)
					)
					(29
						(EcoNarrator init: 4 0 0 91)
					)
					(else 
						(EcoNarrator init: 4 0 0 59)
					)
				)
			)
			(6 (EcoNarrator init: 4 0 0 90))
			(else 
				(super doVerb: theVerb theTheVerb)
			)
		)
	)
)

(instance pump of EcoView
	(properties
		x 87
		y 157
		approachX 108
		approachY 158
		view 200
		loop 4
		signal $4000
	)
	
	(method (init)
		(super init:)
		(self approachVerbs: 1 4 9 6)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 69))
			(4 (global2 setScript: getPump))
			(6 (EcoNarrator init: 4 0 0 70))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance wetRag of EcoView
	(properties
		x 182
		y 145
		view 181
		loop 3
		priority 1
		signal $4011
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 76))
			(4
				(global2 setScript: getWetRag)
			)
			(6 (EcoNarrator init: 4 0 0 77))
			(44
				(if (== theTheVerb 22)
					(EcoNarrator init: 4 0 0 79)
				else
					(super doVerb: theVerb theTheVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance Gregarious of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 240
		charNum 7
		keepWindow 1
	)
	
	(method (init)
		(if (== ((Inv at: 0) owner?) 335)
			(= view 249)
			(gMouth nsLeft: 9 nsTop: 16)
			(gEyes nsLeft: 13 nsTop: 13)
		else
			(= view 240)
			(gMouth nsLeft: 9 nsTop: 16)
			(gEyes nsLeft: 13 nsTop: 13)
		)
		(gBust view: view)
		(gEyes view: view)
		(gMouth view: view)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of EcoProp
	(properties
		view 240
	)
)

(instance gEyes of EcoProp
	(properties
		nsTop 13
		nsLeft 13
		view 240
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of EcoProp
	(properties
		nsTop 16
		nsLeft 9
		view 240
		loop 1
		cycleSpeed 10
	)
)

(instance porchLight of EcoProp
	(properties
		view 200
		loop 8
		cel 2
		priority 4
		signal $4010
		detailLevel 2
	)
	
	(method (init)
		(= cel (Random 0 3))
		(= cycleSpeed (Random 4 12))
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== loop 8)
					(EcoNarrator init: 4 0 0 62)
				else
					(EcoNarrator init: 4 0 0 61)
				)
			)
			(4
				(if (== loop 8)
					(EcoNarrator init: 4 0 0 10)
				else
					(EcoNarrator init: 4 0 0 9)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)
