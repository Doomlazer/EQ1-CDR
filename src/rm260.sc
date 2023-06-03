;;; Sierra Script 1.0 - (do not remove this comment)
(script# 260)
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
	rm260 0
)

(procedure (localproc_030b)
	(cond 
		((== gSouth (global2 north?)) (if (< (gEgo x?) 110) (gEgo x: 115)))
		((== gSouth (global2 south?))
			(cond 
				((<= (gEgo x?) 35) (gEgo x: 21))
				((and (< 35 (gEgo x?)) (< (gEgo x?) 150)) (gEgo x: 95))
			)
		)
	)
)

(procedure (localproc_036c &tmp gDelphX gDelphY)
	(cond 
		((== gSouth (global2 north?))
			(if (> (gEgo x?) 110)
				(if (> (gEgo x?) 210)
					(gDelph x: 140)
				else
					(gDelph x: 270)
				)
				(gDelph y: -70)
			)
			(= gDelphX (gDelph x?))
			(= gDelphY (+ (gDelph y?) 100))
		)
		((== gSouth (global2 south?))
			(cond 
				((<= (gEgo x?) 35) (gDelph x: 100))
				((and (< 35 (gEgo x?)) (< (gEgo x?) 150)) (gDelph x: 207))
				((> (gEgo x?) 260) (gDelph x: 207))
				(else (gDelph x: 300))
			)
			(gDelph y: 270)
			(= gDelphX (gDelph x?))
			(= gDelphY (- (gDelph y?) 100))
		)
		(else
			(if (> (gEgo y?) 100)
				(gDelph y: 50)
			else
				(gDelph y: 150)
			)
			(gDelph x: 390)
			(= gDelphX (- (gDelph x?) 100))
			(= gDelphY (gDelph y?))
		)
	)
	(gDelph show: setMotion: MoveTo gDelphX gDelphY)
)

(instance rm260 of EcoRoom
	(properties
		picture 300
		style $0007
		horizon 15
		north 340
		east 280
		south 240
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
			add: northExit eastExit southExit westBlock southBlock northBlock
			eachElementDo: #init
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						1
						0
						97
						0
						97
						7
						92
						15
						88
						49
						100
						81
						109
						106
						104
						129
						83
						169
						83
						189
						36
						189
						28
						151
						30
						132
						4
						116
						2
						140
						6
						189
						0
						189
						0
						0
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 122 189 143 167 144 150 168 157 182 171 182 176 195 189 123 189
					yourself:
				)
		)
		(= style 10)
		(localproc_030b)
		(localproc_036c)
		(super init:)
		(if
			(or
				(!= (gLongSong number?) 240)
				(== (gLongSong prevSignal?) -1)
			)
			(gLongSong number: 240 loop: -1 play:)
		)
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
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber north) (gLongSong fade:))
		(super newRoom: newRoomNumber &rest)
	)
)

(instance southExit of EcoFeature
	(properties
		x 20
		y 186
		sightAngle 90
		lookStr 8
	)
	
	(method (doVerb)
		(= x ((User curEvent?) x?))
		(super doVerb: &rest)
	)
	
	(method (onMe param1)
		(if
			(or
				(proc999_4 7 183 34 189 param1)
				(proc999_4 85 183 121 189 param1)
			)
		else
			(proc999_4 197 180 319 189 param1)
		)
	)
)

(instance eastExit of EcoFeature
	(properties
		x 310
		y 89
		nsLeft 301
		nsBottom 179
		nsRight 319
		sightAngle 90
		lookStr 7
	)
)

(instance northExit of EcoFeature
	(properties
		x 199
		y 6
		nsLeft 98
		nsBottom 12
		nsRight 300
		sightAngle 90
		lookStr 6
	)
)

(instance northBlock of EcoFeature
	(properties
		x 48
		y 6
		nsTop 1
		nsBottom 12
		nsRight 97
		sightAngle 90
		lookStr 4
	)
)

(instance southBlock of EcoFeature
	(properties
		x 3
		y 186
		sightAngle 90
		lookStr 3
	)
	
	(method (doVerb)
		(= x ((User curEvent?) x?))
		(super doVerb: &rest)
	)
	
	(method (onMe param1)
		(if
			(or
				(proc999_4 0 183 6 189 param1)
				(proc999_4 35 183 84 189 param1)
			)
		else
			(proc999_4 122 183 196 189 param1)
		)
	)
)

(instance westBlock of EcoFeature
	(properties
		x 3
		y 97
		nsTop 13
		nsBottom 182
		nsRight 7
		sightAngle 90
		lookStr 2
	)
)
