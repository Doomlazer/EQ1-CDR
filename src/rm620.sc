;;; Sierra Script 1.0 - (do not remove this comment)
(script# 620)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm620 0
)

(instance rm620 of EcoRoom
	(properties
		picture 620
		style $8007
		horizon 48
		north 344
		east 580
		walkOffTop 1
		lookStr 15
	)
	
	(method (init)
		(= global250 1)
		(= global251 1)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						63
						319
						350
						-50
						350
						-50
						187
						248
						187
						281
						167
						294
						115
						240
						133
						210
						117
						235
						107
						305
						107
						305
						103
						226
						103
						194
						107
						161
						91
						165
						76
						199
						73
						208
						-10
						319
						-10
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 219 135 181 177 63 155 64 129 103 79 112 100 184 141
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 244 168 239 184 214 184 202 176 222 160
					yourself:
				)
			setRegions: 51
		)
		(proc819_6)
		(gEgo init: ignoreHorizon: 1)
		(switch gSouth
			(north
				(= style (= style -32759))
				(self setScript: fromWhale)
			)
			(else 
				(self setScript: outOfShip)
			)
		)
		(plant1 setCycle: Fwd init:)
		(plant2 setCycle: Fwd init:)
		(plant3 setCycle: Fwd init:)
		(if (not (gEgo has: 28)) (saw init:))
		(propeller init:)
		(propShaft init:)
		(skidMarks init:)
		(doorway init:)
		(cabin init:)
		(deck init:)
		(boat init:)
		(purplePlant init:)
		(coralCave init:)
		(greenPlant init:)
		(bulwinklePlant init:)
		(distantCoral init:)
		(distantWaters init:)
		(harpoons init:)
		(super init: &rest)
		(if (not (proc819_5 341)) (cable addToPic:))
		(if (not (proc819_5 85))
			(plant1 setScript: whaleSoundScript)
		)
		(if (!= (gLongSong number?) 420)
			(gLongSong number: 420 loop: -1 play:)
		)
	)
	
	(method (doit)
		(if (> global87 0) (Palette palANIMATE 34 42 7))
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 1)
				(if (not (proc819_5 124))
					(self setScript: goingToCetus)
				else
					0
				)
			)
			(
				(and
					(gEgo inRect: 225 104 236 109)
					(< 35 (gEgo heading?))
					(< (gEgo heading?) 145)
				)
				(self setScript: intoShip)
			)
			((== (gEgo edgeHit?) 4) (self setScript: stayAndHelp))
		)
		(super doit: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(gEgo z: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance fromWhale of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(gEgo z: 30 posn: 100 -4 setMotion: PolyPath 156 106 self)
			)
			(1 (self dispose:))
		)
	)
)

(instance goingToCetus of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(EcoNarrator init: 1 0 0 39 self)
			)
			(1
				(gEgo
					ignoreHorizon: 1
					setMotion: MoveTo (gEgo x?) -40 self
				)
			)
			(2 (global2 newRoom: 344))
		)
	)
)

(instance outOfShip of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(gEgo
					setPri: 7
					posn: 279 82
					setMotion: MoveTo 166 76 self
				)
			)
			(1
				(gEgo z: 30 y: 106 setPri: -1)
				(if (not (proc819_5 85))
					(EcoNarrator init: 1 0 0 32 self)
				else
					(= cycles (= cycles (= cycles (= cycles 1))))
				)
			)
			(2
				(if (not (proc819_5 132))
					(gEgo setScript: whaleCalling)
				)
				(self dispose:)
			)
		)
	)
)

(instance whaleCalling of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(= seconds (= seconds (= seconds (= seconds 60))))
			)
			(1
				(= state (= state (= state (= state -1))))
				(EcoNarrator init: 1 0 0 38 self)
			)
		)
	)
)

(instance intoShip of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(gEgo setPri: 7 setMotion: MoveTo 279 112 self)
			)
			(1
				(global2 newRoom: (global2 east?))
			)
		)
	)
)

(instance whaleSoundScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(whaleSound loop: 1 play: self)
			)
			(1
				(= state (= state (= state (= state -1))))
				(= seconds (= seconds (= seconds (= seconds 8))))
			)
		)
	)
)

(instance whaleSound of Sound
	(properties
		number 647
	)
)

(instance stayAndHelp of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(gEgo setMotion: 0)
				(EcoNarrator init: 1 0 0 16 self)
			)
			(1
				(= temp0 (GetAngle (gEgo x?) (gEgo y?) 160 90))
				(gEgo setHeading: temp0 self)
			)
			(2
				(gEgo setMotion: MoveFwd 20 self)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance cable of EcoView
	(properties
		x 239
		y 14
		view 620
		loop 3
		priority 10
		signal $0011
		lookStr 4
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 5))
			(44
				(switch temp0
					(37 (EcoNarrator init: 1 0 0 6))
					(17 (EcoNarrator init: 1 0 0 7))
					(else 
						(EcoNarrator init: 1 0 0 8)
					)
				)
			)
			(6 (EcoNarrator init: 1 0 0 31))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant1 of EcoProp
	(properties
		x 24
		y 69
		view 620
		loop 1
		signal $4000
		cycleSpeed 20
		detailLevel 3
		lookStr 9
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 10))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant2 of EcoProp
	(properties
		x 90
		y 41
		view 620
		signal $4000
		cycleSpeed 23
		detailLevel 3
		lookStr 9
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 10))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant3 of EcoProp
	(properties
		x 222
		y 179
		view 620
		loop 2
		signal $4000
		cycleSpeed 26
		detailLevel 3
		lookStr 9
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 10))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance propeller of EcoFeature
	(properties
		onMeCheck $4000
		lookStr 19
	)
	
	(method (doVerb theVerb)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (proc999_5 theVerb 4 9 6)
			(EcoNarrator init: 1 0 0 18)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance propShaft of EcoFeature
	(properties
		onMeCheck $2000
		lookStr 19
	)
	
	(method (doVerb)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(super doVerb: &rest)
	)
)

(instance skidMarks of EcoFeature
	(properties
		onMeCheck $1000
		lookStr 33
	)
	
	(method (doVerb)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(super doVerb: &rest)
	)
)

(instance doorway of EcoFeature
	(properties
		onMeCheck $0800
		lookStr 34
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 13))
			(6 (EcoNarrator init: 1 0 0 29))
			(44
				(EcoNarrator init: 1 0 0 27)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance cabin of EcoFeature
	(properties
		onMeCheck $0400
		lookStr 12
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 13))
			(6 (EcoNarrator init: 1 0 0 29))
			(44
				(EcoNarrator init: 1 0 0 27)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance deck of EcoFeature
	(properties
		onMeCheck $0200
		lookStr 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 29))
			(44
				(EcoNarrator init: 1 0 0 27)
			)
			(4 (EcoNarrator init: 1 0 0 14))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance boat of EcoFeature
	(properties
		onMeCheck $0100
		lookStr 17
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 14))
			(6 (EcoNarrator init: 1 0 0 29))
			(44
				(EcoNarrator init: 1 0 0 27)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance purplePlant of EcoFeature
	(properties
		onMeCheck $0080
		lookStr 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 3))
			(6 (EcoNarrator init: 1 0 0 28))
			(44 (EcoNarrator init: 1 0 0 3))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance coralCave of EcoFeature
	(properties
		onMeCheck $0040
		lookStr 25
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 28))
			(44
				(EcoNarrator init: 1 0 0 24)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance greenPlant of EcoFeature
	(properties
		onMeCheck $0020
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 9))
			(4 (EcoNarrator init: 1 0 0 10))
			(6 (EcoNarrator init: 1 0 0 28))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bulwinklePlant of EcoFeature
	(properties
		onMeCheck $0010
		lookStr 25
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 1))
			(44
				(EcoNarrator init: 1 0 0 24)
			)
			(6 (EcoNarrator init: 1 0 0 28))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance distantCoral of EcoFeature
	(properties
		onMeCheck $0008
		lookStr 35
	)
	
	(method (doVerb theVerb)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (== theVerb 4)
			(EcoNarrator init: 1 0 0 16)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance distantWaters of EcoFeature
	(properties
		onMeCheck $0004
		lookStr 36
	)
	
	(method (doVerb)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(super doVerb: &rest)
	)
)

(instance harpoons of EcoFeature
	(properties
		x 202
		y 67
		onMeCheck $0002
		approachX 155
		approachY 85
	)
	
	(method (init)
		(self approachVerbs: 1)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator store: 21 init: 1 0 0 22)
			)
			(6 (EcoNarrator init: 1 0 0 30))
			(4 (EcoNarrator init: 1 0 0 23))
			(44
				(if (== temp0 37)
					(EcoNarrator init: 1 0 0 20)
				else
					(EcoNarrator init: 1 0 0 26)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance saw of EcoView
	(properties
		x 142
		y 94
		approachX 157
		approachY 85
		view 620
		loop 4
		priority 2
		signal $4011
		lookStr 40
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 4)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(EcoNarrator init: 1 0 0 42)
				(gEgo get: 28)
				(proc0_4 1 317)
				(self dispose:)
			)
			(6 (EcoNarrator init: 1 0 0 41))
			(44
				(EcoNarrator init: 1 0 0 43)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)
