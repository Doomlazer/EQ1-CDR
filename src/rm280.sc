;;; Sierra Script 1.0 - (do not remove this comment)
(script# 280)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Polygon)
(use Cycle)
(use User)
(use Obj)

(public
	rm280 0
)

(procedure (localproc_0299)
	(cond 
		((== gSouth (global2 south?)) (if (> (gEgo x?) 240) (gEgo x: 272)))
		((< (gEgo y?) 32) (gEgo y: 35))
	)
)

(procedure (localproc_02d3 &tmp gDelphX gDelphY)
	(if (== gSouth (global2 south?))
		(if (and (< 130 (gEgo x?)) (< (gEgo x?) 239))
			(gDelph x: 80)
		else
			(gDelph x: 175)
		)
		(gDelph y: 270)
		(= gDelphX (gDelph x?))
		(= gDelphY (- (gDelph y?) 100))
	else
		(if (< (gEgo y?) 100)
			(gDelph y: 150)
		else
			(gDelph y: 50)
		)
		(gDelph x: -70)
		(= gDelphX (+ (gDelph x?) 100))
		(= gDelphY (gDelph y?))
	)
	(gDelph show: setMotion: MoveTo gDelphX gDelphY)
)

(instance rm280 of EcoRoom
	(properties
		picture 240
		style $0007
		horizon 15
		south 300
		west 260
		walkOffTop 1
	)
	
	(method (init)
		(= global250 3)
		(proc819_6)
		(gEgo init:)
		(proc819_7)
		(gDelph
			setPri: 15
			z: 0
			init:
			hide:
			lookStr: 5
			talkScript: (ScriptID 241 0)
		)
		(gFeatures
			add: westExit southExit eastBlock southBlock northBlock
			eachElementDo: #init
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						261
						189
						236
						189
						235
						174
						248
						134
						263
						97
						267
						73
						286
						73
						283
						103
						270
						136
						266
						153
						262
						189
						238
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						281
						189
						296
						165
						306
						133
						316
						96
						309
						54
						219
						34
						168
						37
						87
						29
						28
						16
						16
						30
						0
						30
						0
						0
						319
						0
						319
						189
					yourself:
				)
		)
		(= style 10)
		(localproc_0299)
		(localproc_02d3)
		(super init:)
	)
	
	(method (dispose)
		(gDelph lookStr: 0 talkScript: 0)
		(DisposeScript 241)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 1))
			(4
				((ScriptID 2 0) init: 2 0 0 1 1)
			)
			(44
				((ScriptID 2 0) init: 2 0 0 1 1)
			)
			(6 (EcoNarrator init: 3 0 0 9))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance westExit of EcoFeature
	(properties
		x 6
		y 110
		nsTop 31
		nsBottom 189
		nsRight 13
		sightAngle 90
		lookStr 7
	)
)

(instance southExit of EcoFeature
	(properties
		x 124
		y 184
		sightAngle 90
		lookStr 6
	)
	
	(method (doVerb)
		(= x ((User curEvent?) x?))
		(super doVerb: &rest)
	)
	
	(method (onMe param1)
		(if (proc999_4 14 180 234 189 param1)
		else
			(proc999_4 264 183 280 189 param1)
		)
	)
)

(instance southBlock of EcoFeature
	(properties
		x 249
		y 184
		sightAngle 90
		lookStr 4
	)
	
	(method (doVerb)
		(= x ((User curEvent?) x?))
		(super doVerb: &rest)
	)
	
	(method (onMe param1)
		(if (proc999_4 235 180 263 189 param1)
		else
			(proc999_4 281 180 319 189 param1)
		)
	)
)

(instance eastBlock of EcoFeature
	(properties
		x 313
		y 90
		nsTop 1
		nsLeft 308
		nsBottom 179
		nsRight 319
		sightAngle 90
		lookStr 3
	)
)

(instance northBlock of EcoFeature
	(properties
		x 153
		y 15
		nsTop 1
		nsBottom 29
		nsRight 307
		sightAngle 90
		lookStr 2
	)
)
