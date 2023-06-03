;;; Sierra Script 1.0 - (do not remove this comment)
(script# 420)
(include sci.sh)
(use Main)
(use EcoRoom)
(use Garbage)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use Cycle)
(use Obj)

(public
	rm420 0
)

(local
	local0
	local1
	[local2 12] = [-1 -1 -340 60 15 -20 90 340 105 80 210 -32768]
	[local14 16] = [-1 0 240 -20 15 -20 60 270 77 8192 -1 340 97 -20 83 -32768]
	[local30 20] = [-1 1 -340 105 15 45 120 8192 -1 340 120 -20 75 50 67 8192 -1 340 30 -32768]
)
(instance rm420 of EcoRoom
	(properties
		picture 420
		style $000a
		horizon 10
		east 440
		west 100
		lookStr 46
	)
	
	(method (init)
		(= global250 1)
		(= global251 1)
		(proc819_6)
		(gEgo ignoreActors: init: setPri: 13)
		(if (not (proc819_5 73))
			(proc819_7)
			(gDelph init: setPri: 12 z: 0 ignoreActors: hide:)
		)
		(proc819_3 107)
		(if (not (proc819_5 73))
			(switch gSouth
				(east
					(gDelph
						show:
						posn: 405 100
						setHeading: 270
						setMotion: MoveFwd 120
					)
				)
				(else 
					(gDelph
						show:
						posn: -85 100
						setHeading: 90
						setMotion: MoveFwd 120
					)
				)
			)
		)
		(gFeatures
			add: city colossusHead tire plants ledge frond
			eachElementDo: #init
		)
		(gCast
			add: bear flamingo larryDoll boxers
			eachElementDo: #init
		)
		(super init:)
		(self setRegions: 51 50)
		((ScriptID 50 0) addFish: @local14 @local30 @local2)
		(if (not (gEgo has: 23))
			(mirror init: setPri: 11 stopUpd:)
			(damselFish init: setCycle: Fwd)
		)
		(if (not (proc819_5 248)) (glassJar init: stopUpd:))
		(kelpBed1 init: setPri: 5 setCycle: Fwd)
		(kelpBed2 init: setPri: 14 stopUpd:)
		(if (== global233 2)
			(ear init:)
		else
			(blueGlow init: setPri: 10 setCycle: Fwd)
		)
		(self
			setRegions: 51
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 10 0 10
					yourself:
				)
		)
		(if (!= (gLongSong number?) 420)
			(gLongSong number: 420 loop: -1 play:)
		)
	)
	
	(method (doit)
		(super doit:)
		(Palette palANIMATE 214 224 1)
		(cond 
			(script 0)
			((& (gEgo onControl: 1) $4000) (global2 newRoom: 120))
			((== (gEgo edgeHit?) 3) (global2 setScript: cantGoThatWay))
		)
	)
	
	(method (newRoom newRoomNumber)
		(gSoundEffects flags: 0)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (notify)
		(if (not (gEgo has: 23))
			(damselFish setScript: kissMirror)
		)
	)
)

(instance waitForNothing of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 131 92 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 421
					loop: 0
					cel: 0
					x: 136
					y: 78
					cycleSpeed: 20
					setPri: 14
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 421
					loop: 1
					cel: 0
					x: 136
					y: 78
					cycleSpeed: 10
					setCycle: Fwd
				)
				(= cycles 10)
			)
			(3
				(EcoNarrator init: 1 0 0 2 self)
				(= cycles 1)
			)
			(4
				(proc819_6 0)
				(gEgo ignoreActors: posn: 140 74 setPri: 13)
				(= cycles 1)
			)
			(5
				(gEgo setHeading: 90)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance jarOnEar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 131 92 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 421
					loop: 0
					cel: 0
					x: 136
					y: 78
					cycleSpeed: 20
					setPri: 14
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 421
					loop: 1
					cel: 0
					x: 136
					y: 78
					cycleSpeed: 10
					setCycle: Fwd
				)
				(= cycles 25)
			)
			(3
				(EcoNarrator init: 1 0 0 29 self)
			)
			(4 (= cycles 20))
			(5
				(blueGlow
					view: 422
					loop: 1
					cel: 0
					x: 178
					y: 56
					priority: 14
					setCycle: End
				)
				(= cycles 15)
			)
			(6
				(EcoNarrator init: 1 0 0 30 self)
			)
			(7
				(= global233 2)
				(gEgo get: 32)
				(proc0_4 10 306)
				(blueGlow dispose:)
				(ear init:)
				(= cycles 1)
			)
			(8
				((ScriptID 2 0) init: 2 0 0 22 1 self)
			)
			(9
				(EcoNarrator init: 1 0 0 31 self)
			)
			(10
				(proc819_6 0)
				(gEgo ignoreActors: posn: 140 74 setPri: 13)
				(= cycles 1)
			)
			(11
				(gEgo setHeading: 90)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance getMirror of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 143 162 self)
			)
			(1
				(gEgo view: 421 loop: 8 cel: 0 x: 143 y: 162)
				(gEgo get: 23)
				(mirror dispose:)
				(= cycles 2)
			)
			(2
				(proc0_4 2 305)
				(proc819_6)
				(gEgo ignoreActors: setPri: 13)
				(= cycles 12)
			)
			(3
				(EcoNarrator init: 1 0 0 17 self)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 20 1 self)
			)
			(5 (proc0_2) (self dispose:))
		)
	)
)

(instance getJar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 179 145 self)
			)
			(1 (gEgo setHeading: 270 self))
			(2
				(gEgo
					setCycle: 0
					view: 421
					loop: 8
					cel: 0
					posn: 168 149
					cycleSpeed: 13
					setCycle: CT 3 1 self
				)
			)
			(3
				(EcoNarrator init: 1 0 0 8 self)
			)
			(4
				(proc0_4 2 248)
				(glassJar dispose:)
				(gEgo get: 32 setCycle: End self)
			)
			(5
				(proc819_6 1)
				(gEgo ignoreActors: posn: 179 145 setPri: 13)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance lookAtGlow of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 150 76 self)
			)
			(1
				(proc819_9 gEgo blueGlow)
				(= cycles 15)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 7 1 self)
			)
			(3
				(gEgo ignoreActors: setMotion: MoveTo 117 28 self)
			)
			(4
				(proc819_9 gEgo gDelph)
				(= seconds 1)
			)
			(5
				(gDelph setMotion: MoveTo 132 76 self)
			)
			(6
				(proc819_7)
				(gDelph setPri: 12 z: 0 ignoreActors:)
				(proc819_9 gEgo gDelph)
				(proc819_9 gDelph blueGlow)
				(= seconds 2)
			)
			(7
				((ScriptID 2 0) init: 2 0 0 8 1 self)
			)
			(8
				((ScriptID 2 1) init: 3 0 0 2 1 self)
			)
			(9
				((ScriptID 2 0) init: 2 0 0 9 1 self)
			)
			(10
				(proc819_7)
				(gDelph
					setPri: 12
					z: 0
					ignoreActors:
					setMotion: MoveTo 35 100 self
				)
			)
			(11
				(proc819_9 gDelph gEgo)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance kissMirror of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
		(and (< state 5) (<= (gEgo distanceTo: damselFish) 50))
			(= state 4)
			(= cycles 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(damselFish
					view: 423
					loop: 0
					cel: 0
					posn: 177 152
					setCycle: CT 1 1 self
				)
			)
			(1
				(damselFish
					view: 423
					loop: 0
					cel: 2
					posn: 177 152
					setCycle: End self
				)
			)
			(2
				(damselFish
					view: 423
					loop: 1
					cel: 0
					posn: 177 152
					setCycle: CT 4 1 self
				)
			)
			(3
				(gSoundEffects number: 421 loop: 1 flags: 1 play:)
				(damselFish cel: 5 setCycle: End self)
			)
			(4 (= state 0) (= cycles 1))
			(5
				(damselFish
					view: 423
					loop: 2
					cel: 0
					posn: 177 152
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(6
				(if (< (gEgo x?) 160)
					(= local1 1)
					(damselFish
						view: 423
						setLoop: 3
						cel: 0
						posn: 182 152
						cycleSpeed: 2
						setCycle: Fwd
					)
				else
					(damselFish
						view: 423
						setLoop: 4
						cel: 0
						posn: 166 152
						cycleSpeed: 2
						setCycle: Fwd
					)
				)
				(= cycles 2)
			)
			(7
				(EcoNarrator init: 1 0 0 98 self)
			)
			(8
				(if (== local1 1)
					(damselFish setMotion: MoveTo 330 140 self)
				else
					(damselFish setPri: 12 setMotion: MoveTo -10 140 self)
				)
			)
			(9
				(damselFish setScript: 0 dispose:)
			)
		)
	)
)

(instance lookAtFlam of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 2 0 0 21 1 self)
			)
			(1
				((ScriptID 2 1) init: 3 0 0 5 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance cantGoThatWay of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1
				(if (== local0 0)
					(EcoNarrator init: 1 0 0 9 self)
				else
					((ScriptID 2 1) init: 3 0 0 3 1 self)
				)
			)
			(2
				(= local0 1)
				(gEgo setMotion: MoveTo (gEgo x?) (- (gEgo y?) 7) self)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance damselFish of EcoActor
	(properties
		x 177
		y 152
		view 423
		loop 3
		priority 11
		signal $5010
		cycleSpeed 9
		xStep 9
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				((ScriptID 2 0) init: 2 0 0 13)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 18)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 19)
			)
			(44
				(EcoNarrator init: 1 0 0 47)
			)
			(6 (EcoNarrator init: 1 0 0 52))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance city of EcoFeature
	(properties
		onMeCheck $4000
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 16 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance colossusHead of EcoFeature
	(properties
		onMeCheck $0004
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (not (== global233 2)) (EcoNarrator store: 28))
				(EcoNarrator init: 1 0 0 1)
			)
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 6 1)
				)
			)
			(2
				(if (proc819_5 73)
					(super doVerb: theVerb)
				else
					((ScriptID 2 0) init: 2 0 0 5 1)
				)
			)
			(44
				(switch temp0
					(32
						(EcoNarrator init: 1 0 0 32)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(6 (EcoNarrator init: 1 0 0 53))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance tire of EcoFeature
	(properties
		onMeCheck $0008
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator store: 42 init: 1 0 0 24)
			)
			(4 (EcoNarrator init: 1 0 0 25))
			(2 (EcoNarrator init: 1 0 0 43))
			(6 (EcoNarrator init: 1 0 0 40))
			(44
				(switch temp0
					(29
						(EcoNarrator init: 1 0 0 41)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plants of EcoFeature
	(properties
		onMeCheck $0010
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 4))
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 17)
				)
			)
			(6 (EcoNarrator init: 1 0 0 37))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance ledge of EcoFeature
	(properties
		onMeCheck $0020
		lookStr 3
	)
)

(instance frond of EcoFeature
	(properties
		onMeCheck $0040
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance ear of EcoFeature
	(properties
		x 175
		y 63
		nsTop 56
		nsLeft 170
		nsBottom 71
		nsRight 180
		approachX 145
		approachY 63
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 9 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 11 1)
				)
			)
			(4 (EcoNarrator init: 1 0 0 35))
			(44
				(switch temp0
					(29
						(EcoNarrator init: 1 0 0 39)
					)
					(else 
						(EcoNarrator init: 1 0 0 35)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance mirror of EcoView
	(properties
		x 161
		y 178
		approachX 134
		approachY 171
		view 420
		loop 4
		signal $5000
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 9)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 12 1)
				)
			)
			(4
				(global2 setScript: getMirror)
			)
			(6 (EcoNarrator init: 1 0 0 97))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance glassJar of EcoView
	(properties
		x 148
		y 159
		view 421
		loop 7
		priority 10
		signal $5010
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 99))
			(4 (global2 setScript: getJar))
			(6 (EcoNarrator init: 1 0 0 44))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance bear of Garbage
	(properties
		x 183
		y 157
		view 420
		loop 2
		priority 10
		signal $0010
		flag 1
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 21))
			(4 (EcoNarrator init: 1 0 0 22))
			(6
				(EcoNarrator init: 1 0 0 49 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance flamingo of Garbage
	(properties
		x 130
		y 174
		view 420
		loop 2
		cel 5
		priority 9
		signal $0010
		flag 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(global2 setScript: lookAtFlam)
				)
			)
			(4 (EcoNarrator init: 1 0 0 23))
			(6
				(EcoNarrator init: 1 0 0 50 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance larryDoll of Garbage
	(properties
		x 88
		y 153
		view 420
		loop 2
		cel 2
		priority 9
		signal $0010
		flag 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 18))
			(4 (EcoNarrator init: 1 0 0 19))
			(6
				(EcoNarrator init: 1 0 0 48 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance boxers of Garbage
	(properties
		x 141
		y 148
		view 420
		loop 2
		cel 7
		priority 9
		signal $0010
		lookStr {boxers}
		flag 4
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 26))
			(4 (EcoNarrator init: 1 0 0 27))
			(6
				(EcoNarrator init: 1 0 0 51 self)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance kelpBed1 of EcoProp
	(properties
		x 60
		y 64
		view 420
		loop 1
		signal $5000
		cycleSpeed 20
		detailLevel 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 4))
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 17)
				)
			)
			(6 (EcoNarrator init: 1 0 0 37))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance kelpBed2 of EcoProp
	(properties
		x 252
		y 55
		view 420
		signal $5000
		cycleSpeed 25
		detailLevel 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 4))
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 17)
				)
			)
			(6 (EcoNarrator init: 1 0 0 37))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance blueGlow of EcoProp
	(properties
		x 178
		y 56
		approachX 131
		approachY 92
		view 422
		signal $5000
		cycleSpeed 7
		detailLevel 2
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(global2 setScript: lookAtGlow)
			)
			(4 (EcoNarrator init: 1 0 0 36))
			(44
				(switch temp0
					(41
						(switch global233
							(0
								(global2 setScript: waitForNothing)
							)
							(1
								(global2 setScript: jarOnEar)
							)
						)
					)
					(29
						(EcoNarrator init: 1 0 0 33)
					)
					(15
						(EcoNarrator init: 1 0 0 34)
					)
					(else 
						(EcoNarrator init: 1 0 0 38)
					)
				)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 10 1)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)
