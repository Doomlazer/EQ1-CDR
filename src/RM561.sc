;;; Sierra Script 1.0 - (do not remove this comment)
(script# 561)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Polygon)
(use StopWalk)
(use Grooper)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	RM561 0
)

(local
	gEgoMoveSpeed
)
(instance RM561 of EcoRoom
	(properties
		picture 561
		style $8009
		south 540
		picAngle 80
		vanishingX 180
		vanishingY -24
		lookStr 3
	)
	
	(method (init)
		(= global250 1)
		(= global251 1)
		(= gEgoMoveSpeed (gEgo moveSpeed?))
		(gEgo setSpeed: 12)
		(proc819_3 143)
		(self
			setScript: fromAlgaeCaveScript
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 189 201 189 235 168 208 153 155 157 110 189 0 189
					yourself:
				)
		)
		(gFeatures
			add:
				deadFish
				deadPlant
				spiderWeb
				moss
				stalagmite
				caveOpening
				waste
				barrels
				algae
			eachElementDo: #init
		)
		(gEgo
			setLoop: -1
			setPri: -1
			setLoop: toxicGroop
			setCycle: StopWalk 564
		)
		(cond 
			((not (proc819_5 332)) 0)
			((proc819_5 331) (cable setLoop: 2 cel: 11 init: stopUpd:))
			(else (cable setLoop: 6 cel: 4 init: stopUpd:))
		)
		(gLongSong
			number: (if (not (proc819_3 110)) 560 else 563)
			loop: -1
			play:
		)
		(super init:)
	)
	
	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 210 224 -3)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 32))
			(6 (EcoNarrator init: 1 0 0 43))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (proc999_5 (gLongSong number?) 560 563)
			(gLongSong fade:)
		)
		(gEgo setSpeed: gEgoMoveSpeed)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance fromAlgaeCaveScript of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo
					view: 563
					ignoreHorizon: 1
					init:
					posn: 154 220
					z: 0
					setMotion: MoveTo 174 180 self
				)
			)
			(1
				(EcoNarrator store: 36 init: 1 0 0 1)
				(= cycles (= cycles 1))
			)
			(2 (self dispose:))
		)
	)
)

(instance doCableStuff of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(if (and (proc819_5 330) (proc819_5 331))
					(beeper play:)
				)
				(gEgo put: 31 setMotion: MoveTo 175 125 self)
			)
			(1 (gEgo setHeading: 180 self))
			(2
				(gEgo
					view: 561
					setLoop: 1
					cel: 0
					posn: 204 110
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 2 cel: 0 posn: 180 110 setCycle: End self)
				(cable init: loop: 6 cel: 0 stopUpd:)
			)
			(4
				(client
					setScript:
						(cond 
							((and (proc819_5 330) (proc819_5 331)) (proc0_4 10 333) attachCableAndXmitter)
							((proc819_5 331) attachCableAndFloat)
							(else attachCable)
						)
				)
			)
		)
	)
)

(instance attachCable of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(cable loop: 6 cel: 0 setCycle: End self)
			)
			(1
				(EcoNarrator init: 1 0 0 8 self)
			)
			(2
				(gEgo view: 563 setLoop: -1 posn: 192 125 setCycle: Walk)
				(self dispose:)
			)
		)
	)
)

(instance attachCableAndFloat of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(cable loop: 7 cel: 0 setCycle: End self)
			)
			(1
				(EcoNarrator init: 1 0 0 9 self)
			)
			(2 (= seconds (= seconds 1)))
			(3
				(EcoNarrator init: 1 0 0 10 self)
			)
			(4
				(gEgo view: 563 setLoop: -1 posn: 179 140 setCycle: Walk)
				(self dispose:)
			)
		)
	)
)

(instance bringCableBack of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setMotion: MoveTo 192 125 self)
			)
			(1 (gEgo setHeading: 360 self))
			(2
				(if (proc819_5 331)
					(= register (= register 1))
					(EcoNarrator init: 1 0 0 11 self)
				else
					(= register (= register 0))
					(EcoNarrator init: 1 0 0 12 self)
				)
			)
			(3
				(gEgo
					view: 562
					setLoop: register
					cel: 0
					posn: 216 110
					cycleSpeed: 28
					setCycle: End self
				)
				(cable dispose:)
			)
			(4
				(gEgo
					get: 31
					view: 563
					setLoop: -1
					posn: 179 140
					setCycle: Walk
					setMotion: MoveTo 150 160 self
				)
				(self dispose:)
			)
		)
	)
)

(instance attachCableAndXmitter of HandsOffScript
	(properties)
	
	(method (dispose)
		(if script (script dispose:))
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(cable loop: 2 setCycle: End self)
			)
			(1
				(EcoNarrator init: 1 0 0 20 self)
			)
			(2
				(gCast eachElementDo: #hide)
				(global2 drawPic: 901 9)
				(= seconds (= seconds 2))
			)
			(3
				(global2 drawPic: 320 9)
				(gLongSong number: 923 loop: -1 play:)
				(ship init: setCycle: 0 setMotion: MoveTo 298 79 self)
				(wake init: setCycle: Fwd)
				(bouy init: setCycle: Fwd)
				(= seconds (= seconds 3))
			)
			(4
				(ship setMotion: 0 stopUpd:)
				(wake
					posn: 205 104
					loop: 2
					cel: 6
					cycleSpeed: 26
					setCycle: End self
				)
			)
			(5
				(wake stopUpd:)
				(= seconds (= seconds 2))
			)
			(6
				(frog1 init: setCycle: CT 3 1 self)
				(frog2 init: stopUpd:)
				(wake dispose:)
			)
			(7
				(gSoundEffects number: 398 loop: 1 play:)
				(frog1 setCycle: End self)
			)
			(8
				(frog2 setCycle: CT 5 1 self)
			)
			(9
				(gSoundEffects number: 398 loop: 1 play:)
				(frog2 setCycle: End self)
			)
			(10 (= seconds (= seconds 2)))
			(11
				(beeper stop:)
				(gLongSong number: 420 loop: -1 play:)
				(global2 drawPic: 901 9)
				(gCast eachElementDo: #hide)
				(= seconds (= seconds 2))
			)
			(12
				(EcoNarrator init: 1 0 0 35 self)
			)
			(13 (global2 newRoom: 560))
		)
	)
)

(instance beeper of Sound
	(properties
		number 561
		loop -1
	)
)

(instance cable of EcoProp
	(properties
		x 216
		y 110
		approachX 210
		approachY 140
		view 560
		loop 2
		priority 6
		signal $4810
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
			(1
				(EcoNarrator
					init: 1 0 0 (if (proc819_5 331) 10 else 21)
				)
			)
			(4
				(global2 setScript: bringCableBack)
			)
			(44
				(switch temp0
					(38
						(if (not (proc819_5 331))
							(EcoNarrator init: 1 0 0 13)
						else
							(EcoNarrator init: 1 0 0 16)
						)
					)
					(39
						(EcoNarrator init: 1 0 0 14)
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

(instance deadFish of EcoFeature
	(properties
		onMeCheck $0800
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 (if (Random 0 1) 6 else 29))
			)
			(4
				(EcoNarrator init: 1 0 0 (if (Random 0 1) 7 else 30))
			)
			(6 (global2 doVerb: 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadPlant of EcoFeature
	(properties
		onMeCheck $0020
		lookStr 28
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 31))
			(6 (global2 doVerb: 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spiderWeb of EcoFeature
	(properties
		onMeCheck $0040
		lookStr 26
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 32))
			(6 (global2 doVerb: 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stalagmite of EcoFeature
	(properties
		onMeCheck $0080
		lookStr 37
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator init: 1 0 0 lookStr 0 560)
			)
			(6 (global2 doVerb: 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waste of EcoFeature
	(properties
		onMeCheck $4000
		lookStr 2
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 6)
			(global2 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance barrels of EcoFeature
	(properties
		onMeCheck $3000
		lookStr 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 5))
			(6 (global2 doVerb: 6))
			(44
				(switch temp0
					(40
						(proc0_4 5 332)
						(global2 setScript: doCableStuff)
					)
					(38
						(EcoNarrator init: 1 0 0 37)
					)
					(17
						(EcoNarrator init: 1 0 0 37)
					)
					(30
						(EcoNarrator init: 1 0 0 38)
					)
					(12
						(EcoNarrator init: 1 0 0 39)
					)
					(39
						(EcoNarrator init: 1 0 0 40)
					)
					(37
						(EcoNarrator init: 1 0 0 41)
					)
					(29
						(EcoNarrator init: 1 0 0 37)
					)
					(else 
						(EcoNarrator init: 1 0 0 42)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance algae of EcoFeature
	(properties
		onMeCheck $0400
		lookStr 38
	)
	
	(method (doVerb theVerb)
		(cond 
			((== theVerb 6) (global2 doVerb: theVerb))
			((== theVerb 1) (EcoNarrator init: 1 0 1 2 0 560))
			(else (super doVerb: theVerb &rest))
		)
	)
)

(instance moss of EcoFeature
	(properties
		onMeCheck $0200
		lookStr 27
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 6)
			(global2 doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance caveOpening of EcoFeature
	(properties
		onMeCheck $0100
		lookStr 4
	)
)

(instance ship of EcoActor
	(properties
		x 270
		y 86
		view 324
		loop 1
		signal $4800
		cycleSpeed 28
	)
)

(instance wake of EcoProp
	(properties
		x 286
		y 114
		view 324
		cycleSpeed 18
	)
	
	(method (doit)
		(if (> global87 0) (Palette palANIMATE 210 224 1))
		(if (ship mover?)
			(= x (= x (- (ship x?) 12)))
			(= y (= y (+ (ship y?) 35)))
		)
		(super doit: &rest)
	)
)

(instance frog1 of EcoProp
	(properties
		x 170
		y 114
		view 324
		loop 3
		priority 11
		signal $4010
		cycleSpeed 22
	)
)

(instance frog2 of EcoProp
	(properties
		x 226
		y 112
		view 324
		loop 4
		priority 11
		signal $4010
		cycleSpeed 22
	)
)

(instance bouy of EcoProp
	(properties
		x 124
		y 164
		view 560
		loop 3
		cel 2
		signal $4000
		cycleSpeed 14
	)
)

(instance toxicGroop of Grooper
	(properties)
	
	(method (doit &tmp temp0)
		(super doit: &rest)
	)
)
