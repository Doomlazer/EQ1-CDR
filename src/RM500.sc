;;; Sierra Script 1.0 - (do not remove this comment)
(script# 500)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use Path)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	RM500 0
)

(local
	[local0 15] = [140 170 209 146 276 140 40 135 153 60 253 146 241 153 -32768]
)
(instance RM500 of EcoRoom
	(properties
		picture 500
		style $8009
		horizon 20
		north 343
		east 520
		west 480
		picAngle 70
		vanishingX 180
		vanishingY -44
		walkOffTop 1
	)
	
	(method (init)
		(= global250 4)
		(= global251 1)
		(gFeatures
			add:
				deadBrainCoral
				rigPiling
				drillShaft
				subBody
				submersibleHatch
				toilet
				toiletSeat
				subFin
				subSeat
				drillHole
				sickPlant
				subLight
				deadStarfish
			eachElementDo: #init
		)
		(if (not (proc819_5 334))
			(deadFish1 init: stopUpd:)
			(deadFish2 init: stopUpd:)
			(deadFish3 init: stopUpd:)
			(deadFish4 init: stopUpd:)
			(deadFish5 init: stopUpd:)
			(deadFish6 init: stopUpd:)
		)
		(if (not (proc819_5 307))
			(lure init: setScript: lureScript)
		)
		(if (proc819_5 56)
			(lid posn: 106 141 cel: 1)
			(if (not (proc819_5 57)) (ball init: stopUpd:))
		else
			(lid posn: 98 136 cel: 2)
		)
		(lid init: stopUpd:)
		(subPanel init: stopUpd:)
		(proc819_6)
		(gEgo init: ignoreHorizon: 1 z: 30)
		(if (not (proc819_5 73))
			(proc819_7)
			(gDelph
				init:
				posn: (if (== gSouth west) 35 else 330) 56
				ignoreActors: 1
				ignoreHorizon: 1
				setScript: delScript
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 168 100 171 122 119 122 122 100
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 86 319 126 263 105 263 86
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						192
						182
						184
						152
						184
						135
						226
						100
						269
						116
						269
						124
						294
						131
						296
						152
						238
						184
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 164 33 186 319 187 319 389 0 389
					yourself:
				)
			setRegions: 51
		)
		(if (proc819_5 73) (= north (= north 345)))
		(switch gSouth
			(east
				(= style (= style 11))
				(gEgo y: (+ (gEgo y?) (gEgo z?)))
				(if (== global124 gNumber)
					(redFish
						posn: 150 85
						loop: 1
						cycleSpeed: 4
						init:
						setMotion: PolyPath -50 84
					)
					(= global124 480)
				)
			)
			(west
				(= style (= style 12))
				(if (proc819_5 104)
					(gEgo setScript: swimOutOfBrainCoral)
				else
					(gEgo y: (+ (gEgo y?) (gEgo z?)))
				)
				(if (== global124 gNumber)
					(redFish
						posn: 180 55
						loop: 0
						cycleSpeed: 4
						init:
						setMotion: PolyPath 340 45
					)
					(= global124 520)
				)
			)
			(north (gEgo x: 10))
		)
		(super init:)
		(if (!= (gLongSong number?) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(if (!= (gLongSong2 number?) 445)
			(gLongSong2 number: 445 loop: -1 flags: 1 play:)
		)
	)
	
	(method (doit)
		(super doit: &rest)
		(if (> global87 0) (Palette palANIMATE 33 42 7))
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((< ((User curEvent?) y?) 65) (EcoNarrator init: 4 0 0 6))
					((not (proc819_5 73)) ((ScriptID 2 0) init: 1 0 0 3 1))
					(else (super doVerb: theVerb &rest))
				)
			)
			(4
				((ScriptID 2 0) init: 1 0 0 12 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lureScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (lure setCycle: End self))
			(1
				(lureSound play:)
				(lure cel: 0 stopUpd:)
				(= state (= state -1))
				(= cycles (= cycles 10))
			)
		)
	)
)

(instance lureSound of Sound
	(properties
		number 504
	)
)

(instance delScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gDelph setMotion: 0)
				(= seconds (= seconds (Random 3 6)))
			)
			(1
				(delsPath value: 0)
				(gDelph setMotion: delsPath)
				(= seconds (= seconds (Random 8 14)))
			)
			(2
				(if
				(and (< 112 (gDelph x?)) (< (gDelph x?) 180))
					(-- state)
					(gDelph setMotion: MoveTo 40 205 self)
				else
					(self init:)
				)
			)
		)
	)
)

(instance swimOutOfBrainCoral of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo
					setCycle: 0
					view: 502
					loop: 2
					cel: 0
					posn: 63 180 0
					setPri: 15
					setCycle: End self
				)
			)
			(1
				(proc819_6)
				(gEgo view: 805 loop: 4 posn: 84 180 z: 30)
				(= ticks (= ticks 2))
			)
			(2
				(proc819_4 104)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance pryOffLid of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (= seconds (= seconds 1)))
			(1
				(lid hide:)
				(gEgo
					setCycle: 0
					posn: 124 156
					view: 501
					setLoop: 0
					cel: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(2
				(proc819_6)
				(gEgo posn: 173 157 30 loop: 1 heading: 270)
				(lid posn: 106 141 loop: 3 cel: 1 show:)
				(proc0_4 5 318)
				(EcoNarrator init: 4 0 0 42 self)
			)
			(3
				(ball init: stopUpd:)
				(proc819_3 56)
				(self dispose:)
			)
		)
	)
)

(instance getFloat of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo
					setCycle: 0
					view: 501
					posn: 141 134 0
					setPri: 11
					cycleSpeed: 25
					setLoop: 1
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(ball dispose:)
				(gSoundEffects number: 500 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(EcoNarrator init: 4 0 0 25 self)
			)
			(3
				((ScriptID 2 1) init: 2 0 0 6 1 self)
			)
			(4
				((ScriptID 2 0) init: 1 0 0 10 1 self)
			)
			(5
				((ScriptID 2 1) init: 2 0 0 7 1 self)
			)
			(6
				((ScriptID 2 0) init: 1 0 0 11 1 self)
			)
			(7
				(proc819_6)
				(gEgo z: 30 y: 164)
				(proc819_3 57)
				(proc0_4 2 319)
				(gEgo get: 30)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance openSubPanel of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_4 5 316)
				(gEgo
					posn: 271 93 0
					setCycle: 0
					ignoreActors:
					illegalBits: 0
					view: 501
					setLoop: 2
					cel: 0
					setPri: 8
					cycleSpeed: 16
					setCycle: CT 10 1 self
				)
			)
			(1
				(gSoundEffects number: 502 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(subPanel setPri: 5)
				(gEgo
					posn: 254 88
					view: 805
					loop: 6
					setCycle: 0
					heading: 50
					setMotion: MoveTo 276 91 self
				)
			)
			(3
				(proc819_6)
				(gEgo z: 30 y: 121)
				(global2 setScript: showPanel)
			)
		)
	)
)

(instance showPanel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gDelph setPri: 9 setScript: 0 setMotion: 0)
				(gCast eachElementDo: #stopUpd)
				(= ticks (= ticks 3))
			)
			(1
				(if (subPanel priority?)
					(if (not (proc819_5 59))
						(hammer
							init:
							cel: (if (proc819_5 59) 6 else 0)
							stopUpd:
						)
					)
					(if (not (gEgo has: 28)) (saw init: stopUpd:))
					(if (not (proc819_5 84))
						(fishes init:)
						(= seconds (= seconds 3))
					else
						(= ticks (= ticks 3))
					)
					(openPanel init: stopUpd:)
				)
				(panelInset init: show: stopUpd:)
			)
			(2
				(if (not (proc819_5 84))
					(fishes cel: 0 cycleSpeed: 20 setCycle: End self)
				else
					(= ticks (= ticks 2))
				)
			)
			(3
				(if (not (proc819_5 84))
					(proc819_3 84)
					(fishes dispose:)
					(FishNarrator init: 3 0 0 1 self)
				else
					(= ticks (= ticks 2))
				)
			)
			(4
				(if (or (proc819_5 73) (proc819_5 59))
					(= ticks (= ticks 2))
				else
					((ScriptID 2 0) init: 1 0 0 6 1 self)
				)
			)
			(5
				(proc0_2)
				(gIconBar disable: 0)
			)
			(6
				(subPanel setPri: 0 stopUpd:)
				(= cycles (= cycles 6))
			)
			(7
				(panelInset hide:)
				(hammer hide:)
				(saw hide:)
				(openPanel hide:)
				(= cycles (= cycles 3))
			)
			(8
				(panelInset dispose:)
				(hammer dispose:)
				(saw dispose:)
				(openPanel dispose:)
				(= ticks (= ticks 3))
			)
			(9
				(gCast eachElementDo: #startUpd)
				(= ticks (= ticks 3))
			)
			(10
				(if (not (proc819_5 73))
					(gDelph setPri: -1 setScript: delScript)
				)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance tryToGetHammer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gSoundEffects number: 503 loop: 1 play:)
				(hammer cel: 1 setCycle: End self)
			)
			(1
				(EcoNarrator init: 4 0 0 18 self)
			)
			(2
				(hammer stopUpd:)
				(proc819_3 59)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance toiletTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 1 0 0 7 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(2
				((ScriptID 2 0) init: 1 0 0 8 1 self)
			)
			(3
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(4 (self dispose:))
		)
	)
)

(instance lureTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 1 0 0 4 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(2
				((ScriptID 2 0) init: 1 0 0 9 1 self)
			)
			(3 (self dispose:))
		)
	)
)

(instance redFish of EcoActor
	(properties
		yStep 5
		view 443
		signal $6000
		xStep 9
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((== gSouth 520) (EcoNarrator init: 1 0 0 49))
					(else (EcoNarrator init: 1 0 0 50))
				)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 1 1 0 50)
			)
			(6
				(EcoNarrator init: 1 0 0 79 0 50)
			)
			(44
				(switch temp0
					(36
						(EcoNarrator init: 1 0 0 75 0 50)
					)
					(29
						(EcoNarrator init: 1 0 0 74 0 50)
					)
					(37
						(EcoNarrator init: 1 0 0 76 0 50)
					)
					(17
						(EcoNarrator init: 1 0 0 77 0 50)
					)
					(else 
						(EcoNarrator init: 1 0 0 78 0 50)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance panelInset of EcoView
	(properties
		x 198
		y 266
		z 199
		sightAngle 360
		view 500
		priority 12
		signal $4810
	)
	
	(method (init)
		(super init:)
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
		(not (proc999_4 nsLeft nsTop nsRight 95 pEvent))
			(pEvent claimed: 1)
			((global2 script?) cue:)
		else
			(super handleEvent: pEvent &rest)
		)
	)
)

(instance openPanel of EcoView
	(properties
		x 205
		y 267
		z 200
		sightAngle 360
		view 500
		loop 1
		priority 13
		signal $4810
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and (proc819_5 317) (proc819_5 59))
					(EcoNarrator init: 4 0 0 24)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4
				(if (and (proc819_5 317) (proc819_5 59))
					(EcoNarrator init: 4 0 0 39)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance saw of EcoProp
	(properties
		x 205
		y 267
		z 201
		sightAngle 360
		view 500
		loop 2
		priority 14
		signal $4810
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 59)
					((ScriptID 2 1) init: 2 0 0 3 1)
				else
					(EcoNarrator init: 4 0 0 19)
				)
			)
			(4
				(if (proc819_5 59)
					(EcoNarrator init: 4 0 0 21)
					(gEgo get: 28)
					(proc0_4 2 317)
					(self dispose:)
				else
					(hammer doVerb: 4)
				)
			)
			(6 (EcoNarrator init: 4 0 0 64))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance hammer of EcoProp
	(properties
		x 205
		y 269
		z 202
		sightAngle 360
		view 500
		loop 3
		priority 15
		signal $4810
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 59)
					(EcoNarrator init: 4 0 0 51)
				else
					(EcoNarrator init: 4 0 0 19)
				)
			)
			(4
				(if (proc819_5 59)
					(EcoNarrator init: 4 0 0 52)
				else
					(gEgo setScript: tryToGetHammer)
				)
			)
			(6
				(if (proc819_5 59)
					(self dispose:)
					(EcoNarrator init: 4 0 0 53)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fishes of EcoProp
	(properties
		x 202
		y 57
		view 500
		loop 4
		priority 15
		signal $4810
	)
)

(instance lure of EcoProp
	(properties
		x 139
		y 49
		approachX 147
		approachY 94
		view 501
		loop 5
		priority 8
		signal $4010
		cycleSpeed 40
	)
	
	(method (init)
		(line init: stopUpd:)
		(self approachVerbs: 4 1)
		(super init: &rest)
	)
	
	(method (dispose)
		(line dispose:)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 133)
					(EcoNarrator init: 4 0 0 38)
				else
					(proc819_3 133)
					(global2 setScript: lureTalk)
				)
			)
			(4
				(gEgo get: 27)
				(EcoNarrator init: 4 0 0 54)
				(proc0_4 2 307)
				(self dispose:)
			)
			(6 (EcoNarrator init: 4 0 0 55))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance ball of EcoView
	(properties
		x 100
		y 140
		approachX 156
		approachY 129
		view 501
		loop 3
		priority 11
		signal $4010
		lookStr 17
	)
	
	(method (init)
		(self approachVerbs: 4)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(cond 
					((proc819_5 57) (EcoNarrator init: 4 0 0 32))
					((proc819_5 56) (global2 setScript: getFloat))
					(else (EcoNarrator init: 4 0 0 10))
				)
			)
			(else 
				(super doVerb: theVerb temp0)
			)
		)
	)
)

(instance lid of EcoView
	(properties
		x 98
		y 136
		approachX 156
		approachY 129
		view 501
		loop 3
		cel 2
		priority 11
		signal $4010
	)
	
	(method (init)
		(self approachVerbs: 4 9)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((proc819_5 319) (EcoNarrator init: 4 0 0 34))
					((proc819_5 318) (EcoNarrator init: 4 0 0 17))
					(else (EcoNarrator init: 4 0 0 40))
				)
			)
			(4
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 77 79) 0 4))
					((proc819_5 57) (EcoNarrator init: 4 0 0 32))
					((proc819_5 56) (global2 setScript: getFloat))
					(else (EcoNarrator init: 4 0 0 10))
				)
			)
			(44
				(if (== temp0 29)
					(if (proc819_5 56)
						(EcoNarrator init: 4 0 0 63)
					else
						(global2 setScript: pryOffLid)
					)
				else
					(EcoNarrator
						init:
							4
							0
							0
							(switch temp0
								(37 56)
								(12 57)
								(30 58)
								(40 59)
								(39 60)
								(17 61)
								(else  62)
							)
					)
				)
			)
			(6 (EcoNarrator init: 4 0 0 33))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance subPanel of EcoProp
	(properties
		x 293
		y 84
		onMeCheck $0080
		approachX 258
		approachY 84
		view 501
		loop 4
		lookStr 4
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			setPri: 0
			approachVerbs: 4 1
			stopUpd:
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((== priority 0) (EcoNarrator init: 4 0 0 4))
					((proc819_5 74) (EcoNarrator init: 4 0 0 17))
					(else
						(EcoNarrator init: 4 0 0 13)
						((ScriptID 2 0) init: 1 0 0 6 1)
					)
				)
			)
			(4
				(if (!= priority 0)
					(if (proc819_5 317)
						(EcoNarrator init: 4 0 0 39)
					else
						(global2 setScript: showPanel)
					)
				else
					(global2 setScript: openSubPanel)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance deadFish1 of EcoView
	(properties
		x 294
		y 183
		view 560
		cel 3
		signal $4000
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(if (proc999_5 theVerb 6 4)
			(EcoNarrator init: 1 0 0 150 0 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance deadFish2 of EcoView
	(properties
		x 162
		y 174
		view 560
		cel 4
		signal $4000
		lookStr 11
	)
	
	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadFish3 of EcoView
	(properties
		x 295
		y 164
		view 560
		loop 1
		cel 4
		signal $4000
		lookStr 11
	)
	
	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadFish4 of EcoView
	(properties
		x 236
		y 183
		view 560
		loop 1
		cel 1
		signal $4000
		lookStr 11
	)
	
	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadFish5 of EcoView
	(properties
		x 311
		y 179
		view 560
		loop 1
		signal $4000
		lookStr 11
	)
	
	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadFish6 of EcoView
	(properties
		x 121
		y 155
		view 560
		loop 1
		cel 3
		signal $4000
		lookStr 11
	)
	
	(method (doVerb)
		(deadFish1 doVerb: &rest)
	)
)

(instance deadBrainCoral of EcoFeature
	(properties
		y 190
		onMeCheck $0008
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
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 31)
				)
			)
			(6 (EcoNarrator init: 4 0 0 27))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance rigPiling of EcoFeature
	(properties
		onMeCheck $0800
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 1 1)
				)
			)
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 15)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance drillShaft of EcoFeature
	(properties
		onMeCheck $0200
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 14 1)
				)
			)
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance subBody of EcoFeature
	(properties
		onMeCheck $0020
		lookStr 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 28)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance submersibleHatch of EcoFeature
	(properties
		onMeCheck $0100
		lookStr 5
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 29)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance toilet of EcoFeature
	(properties
		onMeCheck $4000
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(global2 setScript: toiletTalk)
				)
			)
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 27)
				)
			)
			(6 (EcoNarrator init: 4 0 0 33))
			(44
				(EcoNarrator
					init:
						4
						0
						0
						(switch temp0
							(37 56)
							(12 57)
							(30 58)
							(40 59)
							(39 60)
							(17 61)
							(else  62)
						)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance toiletSeat of EcoFeature
	(properties
		onMeCheck $1000
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 35)
				)
			)
			(6 (EcoNarrator init: 4 0 0 27))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subSeat of EcoFeature
	(properties
		onMeCheck $0040
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 5 1)
				)
			)
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 1 0 0 13 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subFin of EcoFeature
	(properties
		onMeCheck $0010
		lookStr 65
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 66))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drillHole of EcoFeature
	(properties
		onMeCheck $0400
		lookStr 36
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 37)
				)
			)
			(6 (EcoNarrator init: 4 0 0 37))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sickPlant of EcoFeature
	(properties
		onMeCheck $0004
		lookStr 2
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 27)
				)
			)
			(6 (EcoNarrator init: 4 0 0 27))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subLight of EcoFeature
	(properties
		onMeCheck $2000
		lookStr 22
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 4 0 0 23))
			(44
				(if (== temp0 29)
					(EcoNarrator init: 4 0 0 41)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance deadStarfish of EcoFeature
	(properties
		onMeCheck $0002
		lookStr 26
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 4 0 0 27)
				)
			)
			(6 (EcoNarrator init: 4 0 0 27))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance delsPath of Path
	(properties)
	
	(method (at param1)
		(return [local0 param1])
	)
)

(instance FishNarrator of EcoNarrator
	(properties
		charNum 17
	)
)

(instance line of EcoView
	(properties
		x 139
		y 49
		view 501
		loop 4
		cel 1
		priority 8
		signal $0010
	)
	
	(method (doVerb)
		(lure doVerb: &rest)
	)
)
