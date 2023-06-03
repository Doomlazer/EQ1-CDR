;;; Sierra Script 1.0 - (do not remove this comment)
(script# 225)
(include sci.sh)
(use Main)
(use ApartmentRoom)
(use n804)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PFollow)
(use PolyPath)
(use Polygon)
(use Cycle)
(use InvI)
(use Obj)

(public
	rm225 0
)

(local
	local0 =  231
)
(instance rm225 of ApartmentRoom
	(properties
		picture 220
		style $8007
		east 200
		south 200
		picAngle 60
		lookStr 95
	)
	
	(method (init)
		(= global250 3)
		(= global251 2)
		(= gBelongsTo 3)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						-10
						319
						-10
						319
						182
						274
						150
						305
						96
						300
						31
						225
						12
						67
						25
						25
						81
						47
						145
						110
						154
						238
						189
					yourself:
				)
			setRegions: 51
		)
		(if (proc819_5 299) (= local0 252))
		(if (not (proc819_5 43))
			(manatee view: local0 init: setCycle: Fwd)
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 148 93 194 93 194 115 148 115
						yourself:
					)
			)
		)
		(super init: &rest)
		(plant5 addToPic:)
		(plant4 addToPic:)
		(plant3 addToPic:)
		(plant2 addToPic:)
		(plant1 addToPic:)
		(saw addToPic:)
		(chest addToPic:)
		(wallstuff addToPic:)
		(tools addToPic:)
		(portraits init:)
	)
	
	(method (notify)
		(cond 
			(
				(and
					(not (proc819_5 43))
					(!= ((Inv at: 0) owner?) 335)
				)
				(Gregarious init: 2 0 0 1 1)
			)
			((proc819_5 43) (EcoNarrator init: 3 0 0 96))
			((== ((Inv at: 0) owner?) 335) (Gregarious init: 2 0 0 6 1))
		)
		(proc0_2)
	)
)

(instance gregSwimToSurface of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 156 144 self)
			)
			(1
				(manatee setLoop: 2)
				(gEgo setHeading: 0 self)
			)
			(2
				((ScriptID 2 1) init: 1 0 0 26 1 self)
			)
			(3
				(Gregarious init: 2 0 0 2 1 self)
			)
			(4
				((ScriptID 2 1) init: 1 0 0 27 1 self)
			)
			(5
				(Gregarious init: 2 0 0 3 1 self)
			)
			(6
				((ScriptID 2 1) init: 1 0 0 28 1 self)
			)
			(7
				(Gregarious init: 2 0 0 4 1 self)
			)
			(8
				((ScriptID 2 1) init: 1 0 0 29 1 self)
			)
			(9
				(Gregarious init: 2 0 0 5 1 self)
				(proc819_3 40)
			)
			(10
				(manatee
					view: local0
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 230 130 self
				)
			)
			(11
				(gEgo ignoreActors: 1 setMotion: PFollow manatee 47)
				(manatee
					view: local0
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo 298 188 self
				)
			)
			(12
				(proc0_2)
				(global2 newRoom: 200)
			)
		)
	)
)

(instance manatee of EcoActor
	(properties
		x 168
		y 108
		yStep 3
		view 231
		loop 4
		signal $5000
		illegalBits $0000
		xStep 5
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (== ((Inv at: 0) owner?) 335)
					(EcoNarrator init: 3 0 0 78)
				else
					(EcoNarrator init: 3 0 0 6)
				)
			)
			(4 (EcoNarrator init: 3 0 0 79))
			(2
				(if (== ((Inv at: 0) owner?) 335)
					(Gregarious init: 2 0 0 8 1)
				else
					(global2 setScript: gregSwimToSurface)
				)
			)
			(44 (Gregarious init: 2 0 0 9))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance tools of EcoView
	(properties
		x 101
		y 83
		view 230
		signal $5011
		lookStr 93
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 94))
			(44
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wallstuff of EcoView
	(properties
		x 258
		y 100
		view 230
		cel 1
		signal $5011
		lookStr 11
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
			(4 (EcoNarrator init: 3 0 0 19))
			(44
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance chest of EcoView
	(properties
		x 85
		y 126
		view 230
		loop 1
		signal $5011
		lookStr 76
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 80))
			(44
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance saw of EcoView
	(properties
		x 114
		y 115
		view 230
		loop 1
		cel 1
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 97))
			(4 (EcoNarrator init: 3 0 0 94))
			(44
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant1 of EcoView
	(properties
		x 193
		y 182
		view 230
		loop 2
		priority 15
		signal $5011
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
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant2 of EcoView
	(properties
		x 122
		y 181
		view 230
		loop 2
		cel 1
		priority 15
		signal $5011
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
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant3 of EcoView
	(properties
		x 101
		y 167
		view 230
		loop 2
		cel 2
		priority 15
		signal $5011
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
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant4 of EcoView
	(properties
		x 140
		y 183
		view 230
		loop 2
		cel 2
		priority 15
		signal $5011
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
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant5 of EcoView
	(properties
		x 165
		y 185
		view 230
		loop 2
		cel 2
		priority 15
		signal $5011
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
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance portraits of EcoFeature
	(properties
		x 255
		y 56
		nsTop 45
		nsLeft 229
		nsBottom 67
		nsRight 282
		lookStr 77
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 92))
			(44
				(EcoNarrator init: 3 0 0 98)
			)
			(6 (EcoNarrator init: 3 0 0 99))
			(else 
				(super doVerb: theVerb temp0 &rest)
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
		else
			(= view 240)
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
