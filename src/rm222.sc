;;; Sierra Script 1.0 - (do not remove this comment)
(script# 222)
(include sci.sh)
(use Main)
(use ApartmentRoom)
(use n804)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm222 0
)

(instance rm222 of ApartmentRoom
	(properties
		picture 220
		style $8007
		east 200
		south 200
		lookStr 109
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(= gBelongsTo 1)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						0
						319
						0
						319
						179
						294
						179
						243
						155
						253
						126
						307
						83
						302
						34
						234
						16
						117
						18
						46
						47
						39
						111
						69
						151
						159
						162
						239
						189
					yourself:
				)
			setRegions: 51
		)
		(if (not (proc819_5 51))
			(Epi init: cycleSpeed: 12 setCycle: Fwd)
		)
		(if (proc819_5 17)
			(seaUrchins init: loop: 5 cel: 15 forceUpd: setPri: 2)
		)
		(if (== ((Inv at: 8) owner?) 222)
			(shell init: stopUpd:)
		)
		(super init: &rest)
		(poster1 addToPic:)
		(poster2 addToPic:)
		(case_o_shells addToPic:)
		(plant addToPic:)
		(plant2 addToPic:)
		(plant3 addToPic:)
		(hobostick addToPic:)
		(shadow addToPic:)
	)
	
	(method (notify)
		(if (proc819_3 24)
			(proc0_2)
		else
			(Epi setScript: firstSpeech)
		)
	)
)

(instance firstSpeech of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Epidermis init: 1 0 0 1 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(2
				(Epidermis init: 1 0 0 2 1 self)
			)
			(3 (proc0_2) (= seconds 8))
			(4 (self dispose:))
		)
	)
)

(instance whatsWrong of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(Epi setMotion: 0)
				((ScriptID 2 1) init: 2 0 0 8 1 self)
			)
			(1
				(Epidermis init: 1 0 0 3 0 self)
			)
			(2
				(Epidermis init: 1 0 0 18 1 self)
			)
			(3
				((ScriptID 2 1) init: 2 0 0 9 1 self)
			)
			(4
				(Epidermis init: 1 0 0 4 1 self)
			)
			(5
				((ScriptID 2 1) init: 2 0 0 10 1 self)
			)
			(6
				(Epidermis init: 1 0 0 5 1 self)
			)
			(7
				(proc0_2)
				(proc0_4 2 284)
				(self dispose:)
			)
		)
	)
)

(instance putOnUrchins of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 10))
			(1
				(EcoNarrator init: 3 0 0 116 self)
			)
			(2
				(gEgo
					setCycle: 0
					view: 224
					setLoop: 3
					cel: 0
					setPri: 2
					posn: 253 102
					setCycle: End self
				)
			)
			(3
				(gEgo put: 7 222)
				(proc0_4 10 285)
				(proc819_3 17)
				(seaUrchins init: cycleSpeed: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(EcoNarrator init: 3 0 0 117 self)
			)
			(5
				(if (proc819_5 146)
					(Epidermis init: 1 0 0 20 1 self)
				else
					(Epidermis init: 1 0 0 7 1 self)
				)
			)
			(6
				((ScriptID 2 1) init: 2 0 0 11 1 self)
			)
			(7
				(proc819_6 0)
				(gEgo
					view: 802
					posn: (plant2 approachX?) (plant2 approachY?)
				)
				(seaUrchins
					setLoop: 5
					cel: 0
					cycleSpeed: 35
					setCycle: CT 2 1 self
				)
			)
			(8
				(seaUrchins setCycle: End)
				(= ticks 1)
			)
			(9
				(Epidermis init: 1 0 0 8 1 self)
			)
			(10
				(Epi
					setPri: 15
					setCycle: Walk
					setMotion: MoveTo 281 118 self
				)
			)
			(11
				(Epi setCycle: Fwd)
				(= seconds 6)
			)
			(12
				(EcoNarrator init: 3 0 0 113 self)
			)
			(13
				(Epi
					setCycle: Walk
					setMotion: MoveTo (- (Epi x?) 55) (Epi y?) self
				)
			)
			(14
				(proc819_9 gEgo Epi self)
				(Epi setHeading: 90)
			)
			(15
				(Epidermis init: 1 0 0 9 1 self)
			)
			(16
				((ScriptID 2 1) init: 2 0 0 12 1 self)
			)
			(17
				(Epidermis init: 1 0 0 10 0 self)
			)
			(18
				(Epidermis init: 1 0 0 11 1 self)
			)
			(19
				(self setScript: getShell self)
			)
			(20
				(Epidermis init: 1 0 0 17 0 self)
			)
			(21
				(Epidermis init: 1 0 0 12 1 self)
			)
			(22
				((ScriptID 2 1) init: 2 0 0 14 1 self)
			)
			(23 (gEgo setHeading: 180 self))
			(24 (= cycles 12))
			(25
				(Epi setMotion: PolyPath 346 178 self)
			)
			(26
				(Epi dispose:)
				(proc819_3 51)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance getShell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc819_6 2)
				(gEgo setMotion: MoveTo 191 109 self)
				(Epi
					setPri: -1
					ignoreActors:
					setMotion: MoveTo 80 125 self
				)
			)
			(1 0)
			(2
				(shell dispose:)
				(Epi setMotion: MoveTo 162 114 self)
			)
			(3 (proc819_9 Epi gEgo self))
			(4
				(Epi
					view: 237
					loop: 1
					cel: 0
					posn: 165 117
					setCycle: CT 2 1 self
				)
			)
			(5
				(gEgo
					setCycle: 0
					view: 237
					loop: 0
					cel: 0
					posn: 172 107
					setCycle: CT 2 1 self
				)
			)
			(6
				(Epi setCycle: End self)
				(gEgo setCycle: End self)
			)
			(7 0)
			(8
				(proc819_6 1)
				(proc0_4 2 286)
				(gEgo posn: 183 113 get: 8)
				(Epi view: 225 loop: 0 posn: 165 117 setCycle: Walk)
				(self dispose:)
			)
		)
	)
)

(instance urchinsOnEpi of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc819_3 146)
				((ScriptID 2 1) init: 2 0 0 15 1 self)
			)
			(1
				(Epidermis init: 1 0 0 15 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance potionOnEpi of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 16 1 self)
			)
			(1
				(Epidermis init: 1 0 0 16 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance shell of EcoView
	(properties
		x 74
		y 123
		onMeCheck $0000
		view 224
		loop 1
		cel 2
		priority 1
		signal $4010
	)
)

(instance Epi of EcoActor
	(properties
		x 163
		y 118
		yStep 3
		view 225
		cel 6
		cycleSpeed 8
		xStep 5
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 42))
			(2
				(if (proc819_3 26)
					(Epidermis init: 1 0 0 6 1)
				else
					(global2 setScript: whatsWrong)
				)
			)
			(4 (EcoNarrator init: 3 0 0 44))
			(44
				(switch temp0
					(16
						(if (proc819_5 146)
							(EcoNarrator init: 3 0 0 129)
						else
							(global2 setScript: urchinsOnEpi)
						)
					)
					(12
						(global2 setScript: potionOnEpi)
					)
					(else 
						(Epidermis init: 1 0 0 14)
					)
				)
			)
			(6 (Epidermis init: 1 0 0 19))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance seaUrchins of EcoProp
	(properties
		x 281
		y 164
		z 58
		view 224
		loop 4
		priority 2
		signal $4011
		cycleSpeed 30
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator init: 3 0 0 118)
			)
			(4
				(EcoNarrator init: 3 0 0 119)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance poster1 of EcoView
	(properties
		x 109
		y 90
		view 224
		signal $4011
		lookStr 48
	)
	
	(method (init)
		(super init: &rest)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
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
				(!= (pEvent type?) evVERB)
				(not (pEvent modifiers?))
				(== (gIconBar curIcon?) (gIconBar at: 4))
				(== (gIconBar curInvIcon?) (Inv at: 8))
			)
			(EcoNarrator init: 3 0 0 127)
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
			(4
				(if (gCast contains: Epi)
					(Epidermis init: 1 0 0 13 1)
				else
					(EcoNarrator init: 3 0 0 52)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 124)
			)
			(44
				(EcoNarrator init: 3 0 0 120)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance poster2 of EcoView
	(properties
		x 232
		y 104
		z 20
		view 224
		cel 1
		signal $4011
		lookStr 49
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (gCast contains: Epi)
					(Epidermis init: 1 0 0 13 1)
				else
					(EcoNarrator init: 3 0 0 52)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 124)
			)
			(44
				(EcoNarrator init: 3 0 0 120)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance case_o_shells of EcoView
	(properties
		x 78
		y 136
		view 224
		loop 1
		signal $4011
		lookStr 50
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
			(4
				(if (gEgo has: 8)
					(EcoNarrator init: 3 0 0 53)
				else
					(EcoNarrator init: 3 0 0 51)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 124)
			)
			(44
				(EcoNarrator init: 3 0 0 120)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant of EcoView
	(properties
		x 183
		y 48
		view 224
		loop 1
		cel 1
		signal $4011
		lookStr 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 19))
			(44
				(switch temp0
					(16
						(EcoNarrator init: 3 0 0 128)
					)
					(else 
						(EcoNarrator init: 3 0 0 120)
					)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 124)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant2 of EcoView
	(properties
		x 278
		y 173
		approachX 244
		approachY 100
		view 224
		loop 2
		signal $4011
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 9)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 17)
					(EcoNarrator init: 3 0 0 114)
				else
					(EcoNarrator init: 3 0 0 43)
				)
			)
			(4
				(if (proc819_5 17)
					(EcoNarrator init: 3 0 0 115)
				else
					(EcoNarrator init: 3 0 0 45)
				)
			)
			(44
				(if (proc819_5 26)
					(switch temp0
						(16
							(global2 setScript: putOnUrchins)
						)
						(12
							(if
								(and
									(proc819_5 26)
									(not (== ((Inv at: 7) owner?) 222))
								)
								(EcoNarrator init: 3 0 0 111)
							else
								(super doVerb: theVerb temp0 &rest)
							)
						)
						(22
							(EcoNarrator init: 3 0 0 112)
						)
						(else 
							(cond 
								(
								(and (proc819_5 26) (== ((Inv at: 7) owner?) 222)) (EcoNarrator init: 3 0 0 123))
								((proc819_5 26) (EcoNarrator init: 3 0 0 121))
								(else (EcoNarrator init: 3 0 0 122))
							)
						)
					)
				else
					(EcoNarrator init: 3 0 0 122)
				)
			)
			(6
				(if (== ((Inv at: 7) owner?) 222)
					(EcoNarrator init: 3 0 0 126)
				else
					(EcoNarrator init: 3 0 0 125)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant3 of EcoView
	(properties
		x 118
		y 170
		view 224
		loop 2
		cel 1
		priority 15
		signal $4011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(plant doVerb: theVerb temp0 &rest)
	)
)

(instance hobostick of EcoView
	(properties
		x 53
		y 136
		view 224
		cel 2
		signal $4011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 17)
					(EcoNarrator init: 3 0 0 110)
				else
					(EcoNarrator init: 3 0 0 46)
				)
			)
			(4
				(if (gCast contains: Epi)
					(Epidermis init: 1 0 0 13 1)
				else
					(EcoNarrator init: 3 0 0 47)
				)
			)
			(6
				(EcoNarrator init: 3 0 0 124)
			)
			(44
				(EcoNarrator init: 3 0 0 120)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance shadow of EcoView
	(properties
		x 279
		y 173
		onMeCheck $0000
		view 224
		loop 2
		cel 2
		signal $4011
	)
)

(instance Epidermis of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 234
		viewInPrint 1
		charNum 10
		keepWindow 1
	)
	
	(method (init)
		(super init: eBust eEyes eMouth &rest)
	)
)

(instance eBust of EcoProp
	(properties
		view 234
	)
)

(instance eEyes of EcoProp
	(properties
		nsTop 18
		nsLeft 33
		view 234
		loop 2
		cycleSpeed 30
	)
)

(instance eMouth of EcoProp
	(properties
		nsTop 23
		nsLeft 30
		view 234
		loop 1
		cycleSpeed 10
	)
)
