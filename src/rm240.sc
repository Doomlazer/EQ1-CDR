;;; Sierra Script 1.0 - (do not remove this comment)
(script# 240)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm240 0
)

(procedure (localproc_01ae)
	(cond 
		((== gSouth (global2 east?)) (if (> (gEgo y?) 132) (gEgo y: 132)))
		((< (gEgo x?) 25) (gEgo x: 27))
	)
)

(procedure (localproc_01e8 &tmp gDelphX gDelphY)
	(if (== gSouth (global2 east?))
		(if (> (gEgo y?) 80)
			(gDelph y: 40)
		else
			(gDelph y: 117)
		)
		(gDelph x: 390)
		(= gDelphX (- (gDelph x?) 100))
		(= gDelphY (gDelph y?))
	else
		(if (< (gEgo x?) 170)
			(gDelph x: 210)
		else
			(gDelph x: 120)
		)
		(gDelph y: -70)
		(= gDelphX (gDelph x?))
		(= gDelphY (+ (gDelph y?) 100))
	)
	(gDelph show: setMotion: MoveTo gDelphX gDelphY)
)

(instance rm240 of EcoRoom
	(properties
		picture 280
		style $0007
		horizon 15
		north 260
		east 300
		walkOffTop 1
	)
	
	(method (init)
		(= global250 3)
		(proc819_6)
		(gEgo ignoreHorizon: init:)
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
			add: northExit eastExit westBlock southBlock northBlock
			eachElementDo: #init
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						7
						0
						15
						7
						16
						41
						32
						62
						19
						72
						12
						99
						22
						143
						44
						118
						70
						132
						100
						150
						143
						113
						290
						129
						319
						154
						319
						189
						0
						189
						0
						0
					yourself:
				)
		)
		(= style 10)
		(localproc_01ae)
		(localproc_01e8)
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

(instance northExit of EcoFeature
	(properties
		x 168
		y 3
		nsLeft 17
		nsBottom 7
		nsRight 319
		sightAngle 90
		lookStr 8
	)
)

(instance eastExit of EcoFeature
	(properties
		x 314
		y 76
		nsTop 8
		nsLeft 310
		nsBottom 144
		nsRight 319
		sightAngle 90
		lookStr 7
	)
)

(instance northBlock of EcoFeature
	(properties
		x 8
		y 3
		nsBottom 7
		nsRight 15
		sightAngle 90
		lookStr 4
	)
)

(instance southBlock of EcoFeature
	(properties
		x 159
		y 171
		nsTop 155
		nsBottom 189
		nsRight 318
		sightAngle 90
		lookStr 3
	)
)

(instance westBlock of EcoFeature
	(properties
		x 7
		y 81
		nsTop 8
		nsBottom 154
		nsRight 14
		sightAngle 90
		lookStr 2
	)
)
