;;; Sierra Script 1.0 - (do not remove this comment)
(script# 520)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use Path)
(use Cycle)
(use User)
(use Obj)

(public
	RM520 0
)

(local
	[local0 21] = [32 152 135 144 105 140 66 56 159 130 224 149 280 144 136 149 29 140 50 56 -32768]
)
(procedure (localproc_008a param1 param2)
	(GetDistance
		(param1 x?)
		(- (param1 y?) (param1 z?))
		(param2 x?)
		(- (param2 y?) (param2 z?))
		gPicAngle
	)
)

(instance RM520 of EcoRoom
	(properties
		picture 520
		style $8007
		horizon 10
		west 500
		picAngle 75
		vanishingX 180
		vanishingY 44
		lookStr 6
	)
	
	(method (init)
		(= global250 2)
		(if (and (> global102 16) (== gSouth 540))
			(Palette palSET_INTENSITY 0 255 100)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						148
						319
						189
						0
						189
						0
						186
						311
						186
						311
						150
						284
						152
						219
						143
						202
						122
						210
						104
						312
						104
						312
						61
						246
						61
						172
						116
						62
						104
						62
						73
						134
						73
						144
						53
						0
						53
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 55 74 55 98 0 137 0 74
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 92 161 104 183 34 183 45 161
					yourself:
				)
		)
		(proc819_6)
		(gEgo init: z: 10)
		(if (== gSouth west)
			(= style (= style 12))
			(gEgo y: (- (gEgo y?) 20))
			(if (not (proc819_5 73))
				(proc819_7)
				(gDelph
					init:
					ignoreActors: 1
					setPri: 14
					posn: -10 55
					setScript: delFromWest
				)
			)
			(if (== global124 gNumber)
				(redFish setCycle: Fwd init:)
			)
		else
			(= style (= style $8009))
			(self setScript: exitCaveScript)
			(if (not (proc819_5 73))
				(proc819_7)
				(gDelph init: ignoreActors: 1 setPri: 3 posn: 284 198)
			)
		)
		(gFeatures
			add:
				subRear
				caveEntrance
				staghorn
				deadBrain
				deadFish
				deadPlants
				rocks
				oil
				greenPlants
				distantStuff
				deadReef
			eachElementDo: #init
		)
		(super init:)
		(if (!= (gLongSong number?) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(if (!= (gLongSong2 number?) 445)
			(gLongSong2 number: 445 loop: -1 flags: 1 play:)
		)
	)
	
	(method (doit)
		(if (> global87 0) (Palette palANIMATE 33 42 7))
		(cond 
			(script 0)
			((gEgo inRect: 248 61 312 104) (self newRoom: 540))
		)
		(super doit: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber west)
			(gLongSong fade:)
			(gLongSong2 flags: 0 fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance exitCaveScript of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc819_6)
				(gEgo loop: 1 heading: 270 init: posn: 260 108)
				(if (proc819_5 334)
					(gEgo setMotion: PolyPath 207 82)
					((ScriptID 521 0) init:)
				else
					(gEgo setMotion: PolyPath 143 140 self)
				)
			)
			(1
				(if (gCast contains: gDelph)
					(client setScript: delFromCave)
				)
			)
		)
	)
)

(instance delFromWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gDelph setMotion: 0)
				(= seconds (= seconds (Random 3 5)))
			)
			(1
				(delsPath value: 0)
				(gDelph setMotion: delsPath)
				(= seconds (= seconds (Random 4 10)))
			)
			(2 (self init:))
		)
	)
)

(instance delFromCave of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (= cycles (= cycles 6)))
			(1
				(gDelph setMotion: MoveTo 193 180 self)
			)
			(2
				(gDelph setPri: 14 setMotion: MoveTo 90 146 self)
			)
			(3
				(if (not (proc819_5 324))
					((ScriptID 2 1) init: 3 0 0 1 1 self)
				else
					(gDelph setScript: delFromWest)
					(self dispose:)
				)
			)
			(4
				((ScriptID 2 0) init: 1 0 0 6 1 self)
			)
			(5
				(gDelph setScript: delFromWest)
				(self dispose:)
			)
		)
	)
)

(instance redFishGoBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(= global124 500)
				(= ticks (= ticks 3))
			)
			(1
				(redFish setLoop: 1 setPri: (- (gEgo priority?) 1))
				(if (< (gEgo y?) 100)
					(redFish setMotion: PolyPath 130 165 self)
				else
					(redFish setMotion: PolyPath 70 70 self)
				)
			)
			(2
				(EcoNarrator init: 2 0 0 17 self)
			)
			(3
				(redFish setMotion: PolyPath 62 65 self)
			)
			(4
				(redFish setMotion: PolyPath -50 80 self)
			)
			(5
				(proc0_2)
				(redFish dispose:)
				(self dispose:)
			)
		)
	)
)

(instance redFish of EcoActor
	(properties
		x 210
		y 95
		approachX 130
		approachY 87
		yStep 7
		view 443
		loop 1
		priority 8
		signal $6010
		cycleSpeed 8
		illegalBits $0000
		xStep 11
		lookStr 16
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 9)
	)
	
	(method (doit)
		(if
		(and (< (localproc_008a self gEgo) 80) (not script))
			(self setScript: redFishGoBack)
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (not script)
					(self setScript: redFishGoBack)
				else
					((ScriptID 2 1) init: 2 0 0 1 1 0 50)
				)
			)
			(6
				(EcoNarrator init: 1 0 0 79 0 50)
			)
			(44
				(switch temp0
					(36
						(EcoNarrator init: 1 0 0 75 0 50)
					)
					(29
						(EcoNarrator init: 1 0 0 74 0 50)
					)
					(37
						(EcoNarrator init: 1 0 0 76 0 50)
					)
					(17
						(EcoNarrator init: 1 0 0 77 0 50)
					)
					(else 
						(EcoNarrator init: 1 0 0 78 0 50)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance subRear of EcoFeature
	(properties
		onMeCheck $4000
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 2 0 0 12)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance caveEntrance of EcoFeature
	(properties
		onMeCheck $2000
		approachX 260
		approachY 85
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4)
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 1 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadFish of EcoFeature
	(properties
		onMeCheck $1000
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 77 79) 0 4))
					((not (proc819_5 73)) ((ScriptID 2 0) init: 1 0 0 5 1))
					(else (EcoNarrator init: 2 0 0 15))
				)
			)
			(6 (EcoNarrator init: 2 0 0 15))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadPlants of EcoFeature
	(properties
		onMeCheck $0800
		lookStr 14
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 2 0 0 13)
				)
			)
			(6 (EcoNarrator init: 2 0 0 15))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rocks of EcoFeature
	(properties
		onMeCheck $0200
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((< y 50) (EcoNarrator init: 2 0 0 4))
					(else (EcoNarrator init: 2 0 0 5))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance oil of EcoFeature
	(properties
		onMeCheck $0100
		lookStr 3
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 77 79) 0 4))
					((not (proc819_5 73)) ((ScriptID 2 0) init: 1 0 0 2 1))
					(else (super doVerb: theVerb &rest))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance greenPlants of EcoFeature
	(properties
		onMeCheck $0080
		lookStr 8
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 77 79) 0 4))
					((not (proc819_5 73)) ((ScriptID 2 0) init: 1 0 0 3 1))
					(else (super doVerb: theVerb &rest))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance distantStuff of EcoFeature
	(properties
		onMeCheck $0040
		lookStr 6
	)
	
	(method (doVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(super doVerb: &rest)
	)
)

(instance deadReef of EcoFeature
	(properties
		onMeCheck $0020
		lookStr 1
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 2 0 0 13)
				)
			)
			(6 (EcoNarrator init: 2 0 0 15))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance staghorn of EcoFeature
	(properties
		onMeCheck $0400
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((not (proc819_5 73)) ((ScriptID 2 0) init: 1 0 0 4))
					(else (super doVerb: theVerb &rest))
				)
			)
			(6 (EcoNarrator init: 2 0 0 15))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadBrain of EcoFeature
	(properties
		nsTop 50
		nsLeft 65
		nsBottom 100
		nsRight 100
		onMeCheck $0800
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(6 (EcoNarrator init: 2 0 0 15))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance delsPath of Path
	(properties)
	
	(method (at param1)
		(return [local0 param1])
	)
)
