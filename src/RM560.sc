;;; Sierra Script 1.0 - (do not remove this comment)
(script# 560)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use Cycle)
(use User)
(use Obj)

(public
	RM560 0
)

(instance RM560 of EcoRoom
	(properties
		picture 560
		style $8007
		north 580
		south 540
		picAngle 70
		vanishingX 180
		vanishingY -24
	)
	
	(method (init)
		(= global250 1)
		(= global251 1)
		(self
			setScript:
				(switch gSouth
					(north fromShipScript)
					(561 talkToDelph)
					(else  fromAlgaeCaveScript)
				)
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						207
						189
						306
						165
						189
						165
						187
						154
						260
						141
						140
						141
						207
						121
						165
						125
						126
						125
						163
						108
						97
						108
						122
						6
						15
						6
						63
						130
						155
						157
						40
						189
						0
						189
					yourself:
				)
			setRegions: 51
		)
		(gFeatures
			add: deadFish deadPlant spiderWeb ceilingMoss stalagmite caveEntrance
			eachElementDo: #init
		)
		(super init:)
		(if (!= (gLongSong number?) 420)
			(gLongSong number: 420 loop: -1 play:)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((gEgo inRect: 56 97 115 134) (self setScript: toShipScript))
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator
					init: 1 0 0 (if (< ((User curEvent?) y?) 110) 25 else 24)
				)
			)
			(6 (EcoNarrator init: 1 0 0 39))
			(4 (EcoNarrator init: 1 0 0 32))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fromAlgaeCaveScript of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc819_5 73))
					(proc819_7)
					(gDelph init: posn: 65 290 190)
				)
				(proc819_6)
				(gEgo
					ignoreHorizon: 1
					init:
					posn: 94 220
					z: 28
					setMotion: MoveTo 170 170 self
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance talkToDelph of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc819_6)
				(gEgo
					ignoreHorizon: 1
					init:
					posn: 94 220
					z: 28
					setMotion: MoveTo 170 170 self
				)
			)
			(1
				(proc819_7)
				(gDelph init: posn: 65 290 setMotion: MoveTo 150 190 self)
			)
			(2
				(proc0_4 20 334)
				(gDelph setMotion: MoveTo 154 194 self)
			)
			(3
				((ScriptID 2 0) init: 2 0 0 1 1 self)
			)
			(4
				((ScriptID 2 1) init: 3 0 0 2 0 self)
			)
			(5
				((ScriptID 2 1) init: 3 0 0 3 0 self)
			)
			(6
				((ScriptID 2 1) init: 3 0 0 4 1 self)
			)
			(7
				((ScriptID 2 0) init: 2 0 0 2 1 self)
			)
			(8 (self dispose:))
		)
	)
)

(instance fromShipScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(proc0_1)
				(proc819_6)
				(gEgo ignoreHorizon: 1 init: z: 28)
				(if (proc819_5 132)
					(gEgo setScript: enterShark)
				else
					(gEgo
						heading: 125
						loop: 4
						posn: 93 79
						setMotion: PolyPath 119 126 self
					)
				)
			)
			(1 (proc0_2) (self dispose:))
		)
	)
)

(instance enterShark of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 1 posn: 161 91 setMotion: MoveTo 104 91 self)
				((ScriptID 521 0) init:)
			)
			(1
				(gEgo loop: 5 setMotion: MoveTo 90 105 self)
			)
			(2
				(gEgo loop: 4 setMotion: MoveTo 100 115)
				(self dispose:)
			)
		)
	)
)

(instance toShipScript of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 96 114 self)
			)
			(1
				(global2 newRoom: (global2 north?))
			)
		)
	)
)

(instance deadFish of EcoFeature
	(properties
		onMeCheck $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 (if (Random 0 1) 6 else 29))
			)
			(4
				(EcoNarrator init: 1 0 0 (if (Random 0 1) 7 else 30))
			)
			(6 (EcoNarrator init: 1 0 0 39))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadPlant of EcoFeature
	(properties
		onMeCheck $2000
		lookStr 28
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(EcoNarrator init: 1 0 0 (if (mod x 2) 30 else 31))
			)
			(6 (EcoNarrator init: 1 0 0 39))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spiderWeb of EcoFeature
	(properties
		onMeCheck $1000
		lookStr 26
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 32))
			(6 (EcoNarrator init: 1 0 0 39))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ceilingMoss of EcoFeature
	(properties
		onMeCheck $0800
		lookStr 27
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 6)
			(EcoNarrator init: 1 0 0 39)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance stalagmite of EcoFeature
	(properties
		onMeCheck $0400
		lookStr 37
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 6)
			(EcoNarrator init: 1 0 0 39)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance caveEntrance of EcoFeature
	(properties
		onMeCheck $0200
		approachX 90
		approachY 85
		lookStr 23
	)
	
	(method (init)
		(self approachVerbs: 4)
	)
)
