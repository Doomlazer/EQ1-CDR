;;; Sierra Script 1.0 - (do not remove this comment)
(script# 343)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PFollow)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm343 0
)

(local
	local0 =  1
	local1 =  1
)
(instance rm343 of EcoRoom
	(properties
		picture 347
		style $8009
		horizon -20
		south 480
		lookStr 16
	)
	
	(method (init)
		(= global250 3)
		(proc819_4 107)
		(self setRegions: 51)
		(gFeatures
			add:
				DriftNet
				SawfishBones
				Float1
				Float2
				Float3
				Float4
				Float5
				Weight1
				Weight2
				Weight3
				Weight4
			eachElementDo: #init
		)
		(if (not (gEgo has: 26)) (SawfishSaw init:))
		(DeadPorpi init:)
		(if
		(and (not (proc819_5 67)) (not (proc819_5 73)))
			(lobster init:)
		)
		(proc819_6)
		(gEgo setPri: 3 init:)
		(if (not (proc819_5 73))
			(proc819_7)
			(gDelph
				z: 0
				ignoreHorizon: 1
				setPri: 2
				moveSpeed: 0
				cycleSpeed: 0
				init:
			)
			(gDelph talkScript: firstNetConversation lookStr 19)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: -3 195 -3 -3 322 -3 322 195 316 195 316 3 3 3 3 195
					yourself:
				)
		)
		(super init:)
		(self setScript: fromVertical)
		(if (!= (gLongSong number?) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(gLongSong2 number: 446 loop: -1 flags: 1 play:)
	)
	
	(method (doit)
		(if
			(or
				(not (if (< 26 (gEgo x?)) (< (gEgo x?) 293)))
				(< (gEgo y?) 14)
			)
			(gEgo setMotion: 0)
			(cond 
				((< (gEgo x?) 27) (gEgo x: 27))
				((> (gEgo x?) 292) (gEgo x: 292))
				(else (gEgo y: 14))
			)
			(EcoNarrator init: 3 0 0 28)
		)
		(super doit: &rest)
		(Palette palANIMATE 177 192 -3)
	)
	
	(method (dispose)
		(gDelph lookStr: 0 setMotion: 0)
		(proc819_3 107)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 16))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong2 flags: 0 fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance lobster of EcoActor
	(properties
		x 291
		y 104
		approachX 256
		approachY 108
		view 341
	)
	
	(method (init)
		(super init: &rest)
		(self
			setLoop: 0
			setPri: 3
			ignoreActors: 1
			setCycle: Fwd
			cycleSpeed: 26
		)
		(self approachVerbs: 4 1 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 15))
			(1
				(if
				(and (not (proc819_5 67)) (not (proc819_5 73)))
					(if (== local0 1)
						(rm343 setScript: firstLobsterLookConversation)
					else
						(EcoNarrator init: 3 0 0 11)
					)
				)
			)
			(44
				(switch temp0
					(37
						(EcoNarrator init: 3 0 0 14)
					)
					(17
						(rm343 setScript: freeLobster)
					)
					(else 
						(EcoNarrator init: 3 0 0 13)
					)
				)
			)
			(2 (EcoNarrator init: 3 0 0 12))
			(6 (EcoNarrator init: 3 0 0 26))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SawfishSaw of EcoView
	(properties
		x 269
		y 49
		view 341
		loop 1
	)
	
	(method (init)
		(self setPri: 3 ignoreActors: 1)
		(super init: &rest)
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 21))
			(1
				(if (not (gEgo has: 26)) (EcoNarrator init: 3 0 0 2))
			)
			(6 (EcoNarrator init: 3 0 0 18))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance DeadPorpi of EcoView
	(properties
		x 65
		y 100
		view 341
		loop 2
	)
	
	(method (init)
		(self setPri: 3 ignoreActors: 1)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 25))
			(1 (EcoNarrator init: 3 0 0 24))
			(6 (EcoNarrator init: 3 0 0 18))
			(44
				(if (or (== temp0 17) (== temp0 37))
					(EcoNarrator init: 3 0 0 27)
				else
					(EcoNarrator init: 3 0 0 25)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance DriftNet of EcoFeature
	(properties
		x 155
		y 30
		nsTop 30
		nsLeft 5
		nsBottom 155
		nsRight 310
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 7))
			(1
				(if
				(and (not (proc819_5 142)) (not (proc819_5 73)))
					(rm343 setScript: firstNetConversation)
				else
					(EcoNarrator init: 3 0 0 10)
				)
			)
			(44
				(EcoNarrator init: 3 0 0 22)
			)
			(6 (EcoNarrator init: 3 0 0 8))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SawfishBones of EcoFeature
	(properties
		x 247
		y 103
		z 50
		nsTop 43
		nsLeft 229
		nsBottom 64
		nsRight 266
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 3))
			(1 (EcoNarrator init: 3 0 0 1))
			(44
				(EcoNarrator init: 3 0 0 23)
			)
			(6 (EcoNarrator init: 3 0 0 18))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Float1 of EcoFeature
	(properties
		x 277
		y 10
		nsTop 5
		nsLeft 271
		nsBottom 10
		nsRight 284
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Float2 of EcoFeature
	(properties
		x 186
		y 32
		nsTop 25
		nsLeft 180
		nsBottom 32
		nsRight 192
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Float3 of EcoFeature
	(properties
		x 128
		y 43
		nsTop 38
		nsLeft 123
		nsBottom 43
		nsRight 132
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Float4 of EcoFeature
	(properties
		x 104
		y 59
		nsTop 47
		nsLeft 85
		nsBottom 59
		nsRight 122
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Float5 of EcoFeature
	(properties
		x 33
		y 71
		nsTop 64
		nsLeft 4
		nsBottom 71
		nsRight 58
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Weight1 of EcoFeature
	(properties
		x 270
		y 165
		nsTop 155
		nsLeft 264
		nsBottom 164
		nsRight 275
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Weight2 of EcoFeature
	(properties
		x 174
		y 148
		nsTop 141
		nsLeft 171
		nsBottom 148
		nsRight 177
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Weight3 of EcoFeature
	(properties
		x 100
		y 140
		nsTop 124
		nsLeft 76
		nsBottom 140
		nsRight 123
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Weight4 of EcoFeature
	(properties
		x 33
		y 127
		nsTop 118
		nsLeft 6
		nsBottom 127
		nsRight 59
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= param2 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance firstNetConversation of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc819_5 142)
					((ScriptID 2 0) init: 2 0 0 21 1 self)
					(self dispose:)
				else
					(proc819_3 142)
					((ScriptID 2 1) init: 1 0 0 1 1 self)
				)
			)
			(1 (= seconds 1))
			(2
				((ScriptID 2 0) init: 2 0 0 2 1 self)
			)
			(3
				((ScriptID 2 1) nsTop: 116 init: 1 0 0 4 1 self)
			)
			(4
				((ScriptID 2 1) nsTop: 96 init: 1 0 0 5 1 self)
			)
			(5
				((ScriptID 2 1) init: 1 0 0 6 1 self)
			)
			(6
				((ScriptID 2 0) init: 2 0 0 3 1 self)
			)
			(7
				((ScriptID 2 1) init: 1 0 0 7 1 self)
			)
			(8
				((ScriptID 2 0) init: 2 0 0 4 1 self)
			)
			(9
				(= local1 0)
				(gDelph talkScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance firstLobsterLookConversation of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 1 0 0 8 1 self)
			)
			(1
				((ScriptID 2 0) init: 2 0 0 5 1 self)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 6 1 self)
			)
			(3
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance fromVertical of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 80 190 setMotion: MoveTo 190 120 self)
				(if (not (proc819_5 73))
					(gDelph posn: (gEgo x?) 220 setMotion: PFollow gEgo 90)
				)
			)
			(1
				(if
				(and (not (proc819_5 141)) (not (proc819_5 73)))
					(proc819_3 141)
					((ScriptID 2 0) init: 2 0 0 1 1 self)
				else
					(self dispose:)
				)
			)
			(2
				(gEgo setMotion: MoveTo 215 108 self)
			)
			(3
				(gEgo setHeading: 108)
				(self dispose:)
			)
		)
	)
)

(instance freeLobster of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 275 105 self)
			)
			(1
				(proc0_4 5 308)
				(gEgo setHeading: 90)
				((ScriptID 2 1) init: 1 0 0 9 1 self)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 7 1 self)
			)
			(3
				(lobster
					setLoop: 3
					setCycle: Fwd
					cycleSpeed: 6
					setMotion: MoveTo 330 (lobster y?) self
				)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 8 1 self)
			)
			(5
				(proc819_3 67)
				(lobster dispose:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)
