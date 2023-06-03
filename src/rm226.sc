;;; Sierra Script 1.0 - (do not remove this comment)
(script# 226)
(include sci.sh)
(use Main)
(use ApartmentRoom)
(use n804)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use ForwardCounter)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm226 0
)

(local
	local0
	local1
)
(instance rm226 of ApartmentRoom
	(properties
		picture 220
		style $8007
		east 200
		south 200
		lookStr 28
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(= gBelongsTo 7)
		(super init: &rest)
		(if (not (proc819_5 48))
			(lionFish init: setPri: 2 setCycle: Fwd)
			(waft1 setCycle: Fwd init:)
			(waft2 setCycle: Fwd init:)
		)
		(if (not (proc819_5 53)) (bleach init: setPri: 0))
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						-10
						319
						-10
						319
						179
						283
						171
						275
						111
						306
						62
						293
						28
						225
						10
						120
						15
						37
						51
						33
						112
						65
						147
						191
						165
						239
						189
						0
						189
					yourself:
				)
			setRegions: 51
		)
		(painting addToPic:)
		(wndow addToPic:)
		(couch addToPic:)
		(table addToPic:)
		(plant1 addToPic:)
		(plant2 addToPic:)
		(plant3 addToPic:)
		(plant4 addToPic:)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (not (proc819_5 53))
					(EcoNarrator store: 29 init: 3 0 0 28)
				else
					(EcoNarrator init: 3 0 0 28)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (notify)
		(proc0_2)
	)
)

(instance discardBleach of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo 183 96 self)
			)
			(1 (= cycles 10))
			(2
				(gEgo
					setCycle: 0
					view: 232
					loop: 3
					cel: 0
					x: 139
					y: 101
					cycleSpeed: 14
					setCycle: CT 5 1 self
				)
			)
			(3
				(proc0_4 5 302)
				(proc819_3 53)
				(bleach dispose:)
				(gEgo cel: 6 setCycle: End self)
			)
			(4
				(proc819_6 0)
				(gEgo posn: 160 95 setHeading: 135 self)
			)
			(5
				(EcoNarrator init: 3 0 0 7 self)
			)
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance bleachNotGone of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (Clone waft1))
				(= local1 (Clone waft2))
				(waft1 setCycle: Fwd)
				(waft2 setCycle: Fwd)
				(local0
					init:
					setLoop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: Fwd
				)
				(local1
					init:
					setLoop: 3
					cel: 0
					cycleSpeed: 11
					setCycle: Fwd
				)
				(= seconds 7)
			)
			(1
				(EcoNarrator init: 3 0 0 96 self)
			)
			(2
				(local0 setCycle: End self)
				(local1 setCycle: End)
			)
			(3
				(gEgo setScript: 0)
				(local0 setCycle: 0 dispose:)
				(local1 setCycle: 0 dispose:)
				(= cycles 2)
			)
			(4
				(= local0 (= local1 0))
				(proc819_6 0)
				(gEgo posn: 237 50)
				(= cycles 12)
			)
			(5 (proc0_2) (self dispose:))
		)
	)
)

(instance usePump of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 237 50 self)
			)
			(1 (= cycles 10))
			(2
				(waft1 setCycle: 0)
				(waft2 setCycle: 0)
				(= cycles 1)
			)
			(3
				(if (not (proc819_5 53))
					(EcoNarrator init: 3 0 0 104 self)
				else
					(= cycles 1)
				)
			)
			(4 (= cycles 2))
			(5
				(gEgo
					setCycle: 0
					view: 232
					loop: 4
					cel: 0
					x: 258
					y: 57
					cycleSpeed: 9
					setScript: egoPump
				)
				(if (not (proc819_5 53))
					(global2 setScript: bleachNotGone)
				else
					(= cycles 1)
				)
			)
			(6
				(= local0 (Clone waft1))
				(= local1 (Clone waft2))
				(waft1 setCycle: Fwd)
				(waft2 setCycle: Fwd)
				(local0
					init:
					setLoop: 2
					cel: 0
					cycleSpeed: 10
					setCycle: ForwardCounter 5 self
				)
				(local1
					init:
					setLoop: 3
					cel: 0
					cycleSpeed: 10
					setCycle: Fwd
				)
			)
			(7
				(local0 setCycle: 0 dispose:)
				(local1 setCycle: 0 dispose:)
				(waft1
					setLoop: 2
					cel: 0
					cycleSpeed: 7
					setCycle: End waft1
				)
				(waft2
					setLoop: 3
					cel: 0
					cycleSpeed: 6
					setCycle: End waft2
				)
			)
			(8
				(proc0_4 5 303)
				(proc819_6 0)
				(gEgo setScript: 0 posn: 237 50)
				(= cycles 1)
			)
			(9
				(EcoNarrator init: 3 0 0 8 self)
			)
			(10 (gEgo setHeading: 225 self))
			(11
				(gLongSong number: 206 loop: -1 play:)
				(lionFish
					view: 233
					loop: 4
					cel: 0
					x: 100
					y: 98
					cycleSpeed: 13
					setCycle: End self
				)
			)
			(12
				(lionFish setLoop: 1 cel: 0 cycleSpeed: 9 setCycle: Fwd)
				(= seconds 3)
			)
			(13
				(Olympia init: 1 0 0 1 1 self)
			)
			(14
				((ScriptID 2 1) init: 2 0 0 30 0 self)
			)
			(15
				((ScriptID 2 1) init: 2 0 0 36 1 self)
			)
			(16
				(Olympia init: 1 0 0 2 1 self)
			)
			(17
				((ScriptID 2 1)
					nsLeft: 20
					nsTop: 136
					init: 2 0 0 31 1 self
				)
			)
			(18
				(Olympia init: 1 0 0 3 1 self)
			)
			(19
				((ScriptID 2 1) init: 2 0 0 32 1 self)
			)
			(20
				(Olympia init: 1 0 0 4 1 self)
			)
			(21
				((ScriptID 2 1) init: 2 0 0 33 0 self)
			)
			(22
				((ScriptID 2 1) init: 2 0 0 37 1 self)
			)
			(23
				(Olympia init: 1 0 0 5 1 self)
			)
			(24
				((ScriptID 2 1)
					nsLeft: 20
					nsTop: 136
					init: 2 0 0 34 1 self
				)
			)
			(25
				(lionFish
					view: 233
					loop: 5
					cel: 0
					x: 100
					y: 98
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(26
				(Olympia init: 1 0 0 6 1 self)
			)
			(27
				(gEgo setMotion: PolyPath 212 99 self)
			)
			(28
				(gEgo setHeading: 315)
				(lionFish
					view: 233
					loop: 6
					cel: 0
					x: 194
					y: 91
					cycleSpeed: 10
					setCycle: CT 10 1 self
				)
			)
			(29 (= cycles 10))
			(30
				(proc0_4 2 304)
				(gEgo get: 21)
				(lionFish setCycle: End)
				(gEgo
					setCycle: 0
					view: 233
					loop: 7
					cel: 0
					x: 194
					y: 91
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(31
				(proc819_6 1)
				(gEgo posn: 210 96)
				((ScriptID 2 1) init: 2 0 0 35 1 self)
			)
			(32
				(Olympia init: 1 0 0 7 1 self)
			)
			(33 (gEgo setHeading: 180 self))
			(34 (= cycles 12))
			(35
				(lionFish
					view: 245
					setLoop: 2
					posn: 179 78
					setPri: 15
					setCycle: Fwd
					setMotion: MoveTo 275 172 self
				)
			)
			(36
				(lionFish
					view: 245
					setLoop: 0
					posn: 275 172
					setCycle: Fwd
					setMotion: MoveTo 333 175 self
				)
			)
			(37
				(lionFish dispose:)
				(proc819_3 48)
				(= cycles 1)
			)
			(38 (proc0_2) (self dispose:))
		)
	)
)

(instance egoPump of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSoundEffects number: 213 loop: 1 play:)
				(= state -1)
				(gEgo setCycle: End self)
			)
		)
	)
)

(instance lionFish of EcoActor
	(properties
		x 100
		y 98
		approachX 153
		approachY 96
		view 233
		loop 3
		signal $4000
		cycleSpeed 18
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 9 1 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 81))
			(4 (EcoNarrator init: 3 0 0 89))
			(2 (EcoNarrator init: 3 0 0 82))
			(6 (EcoNarrator init: 3 0 0 93))
			(44
				(if (== temp0 3)
					(EcoNarrator init: 3 0 0 101)
				else
					(EcoNarrator init: 3 0 0 95)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance painting of EcoView
	(properties
		x 83
		y 80
		view 232
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 32))
			(4 (EcoNarrator init: 3 0 0 31))
			(6 (EcoNarrator init: 3 0 0 94))
			(44
				(EcoNarrator init: 3 0 0 99)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wndow of EcoView
	(properties
		x 247
		y 60
		view 232
		cel 1
		signal $5011
	)
	
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
	
	(method (handleEvent pEvent)
		(if
			(and
				(User canInput:)
				(not (global2 script?))
				(!= (pEvent type?) evVERB)
				(not (pEvent modifiers?))
				(== (gIconBar curIcon?) (gIconBar at: 4))
				(== (gIconBar curInvIcon?) (Inv at: 5))
				(== ((Inv at: 21) owner?) 226)
				(not (self onMe: pEvent))
			)
			(EcoNarrator init: 3 0 0 97)
			(pEvent claimed: 1)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 87))
			(4
				(if (gEgo has: 21)
					(EcoNarrator init: 3 0 0 98)
				else
					(EcoNarrator init: 3 0 0 90)
				)
			)
			(44
				(switch temp0
					(14
						(if (not (gEgo has: 21))
							(global2 setScript: usePump)
						else
							(EcoNarrator init: 3 0 0 98)
						)
					)
					(else 
						(EcoNarrator init: 4 0 0 5)
					)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 102)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance couch of EcoView
	(properties
		x 95
		y 97
		z -32
		view 232
		loop 1
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 83))
			(4 (EcoNarrator init: 3 0 0 30))
			(6 (EcoNarrator init: 3 0 0 94))
			(44
				(EcoNarrator init: 3 0 0 99)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance table of EcoView
	(properties
		x 122
		y 139
		view 232
		loop 1
		cel 1
		signal $5011
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
			(1 (EcoNarrator init: 3 0 0 84))
			(4 (EcoNarrator init: 3 0 0 33))
			(6 (EcoNarrator init: 3 0 0 94))
			(44
				(EcoNarrator init: 3 0 0 99)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant1 of EcoView
	(properties
		x 296
		y 127
		view 232
		loop 2
		cel 1
		priority 12
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 11))
			(4 (EcoNarrator init: 3 0 0 19))
			(6 (EcoNarrator init: 3 0 0 94))
			(44
				(EcoNarrator init: 3 0 0 99)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant2 of EcoView
	(properties
		x 234
		y 96
		view 232
		loop 2
		cel 2
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(plant1 doVerb: theVerb temp0 &rest)
	)
)

(instance plant3 of EcoView
	(properties
		x 303
		y 183
		view 232
		loop 2
		cel 3
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(plant1 doVerb: theVerb temp0 &rest)
	)
)

(instance plant4 of EcoView
	(properties
		x 172
		y 186
		view 232
		loop 2
		priority 15
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(plant1 doVerb: theVerb temp0 &rest)
	)
)

(instance bleach of EcoView
	(properties
		x 159
		y 140
		z 24
		approachX 212
		approachY 110
		view 232
		loop 1
		cel 2
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 9 4 1 6)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 85))
			(4 (EcoNarrator init: 3 0 0 88))
			(6
				(global2 setScript: discardBleach)
			)
			(44
				(EcoNarrator init: 3 0 0 103)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance waft1 of EcoProp
	(properties
		x 120
		y 133
		view 247
		signal $4010
		detailLevel 1
		lookStr 29
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (EcoNarrator init: 3 0 0 92))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(usePump cue:)
		(self dispose:)
	)
)

(instance waft2 of EcoProp
	(properties
		x 275
		y 136
		view 247
		signal $4010
		detailLevel 1
		lookStr 29
	)
	
	(method (cue)
		(self dispose:)
	)
)

(instance Olympia of EcoTalker
	(properties
		nsTop 16
		nsLeft 10
		view 242
		charNum 14
		keepWindow 1
	)
	
	(method (init)
		(super init: oBust oEyes oMouth &rest)
	)
)

(instance oBust of EcoProp
	(properties
		view 242
	)
)

(instance oEyes of EcoProp
	(properties
		nsTop 12
		nsLeft 10
		view 242
		loop 2
		cycleSpeed 30
	)
)

(instance oMouth of EcoProp
	(properties
		nsTop 12
		nsLeft 18
		view 242
		loop 1
		cycleSpeed 10
	)
)
