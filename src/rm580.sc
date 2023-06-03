;;; Sierra Script 1.0 - (do not remove this comment)
(script# 580)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use RangeOsc)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use ForwardCounter)
(use n958)
(use DPath)
(use Grooper)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm580 0
)

(local
	[local0 50] = [0 0 101 0 267 0 222 95 121 86 170 122 175 129 118 127 150 145 143 152 122 147 110 150 121 166 68 161 64 138 78 127 109 127 75 108 57 114 39 93 45 129 14 139 0 143 45 189 0 189]
	[local50 48] = [0 0 101 0 93 21 120 43 115 74 126 84 135 95 169 119 175 129 118 127 150 145 143 152 122 147 115 152 117 164 72 162 59 137 74 128 109 127 81 111 5 134 13 154 43 189 0 189]
	[local98 50] = [0 -9 319 -10 319 86 122 86 122 110 170 122 175 129 118 127 150 145 143 152 122 147 116 167 67 161 62 138 78 127 109 127 75 108 57 114 34 97 42 132 14 139 0 143 5 157 53 189 0 189]
	[local148 8] = [265 245 223 201 175 174 176 169]
	[local156 8] = [20 19 22 30 31 25 13 11]
	local164 =  1
)
(procedure (localproc_00f0)
	(cond 
		(
			(and
				(proc819_5 88)
				(proc819_5 73)
				(not (proc819_5 100))
				(not (proc819_5 71))
			)
			(global2 setScript: exitToLair)
		)
		((and (proc819_5 73) (not (proc819_5 88))) (global2 setScript: smackedByManta))
		((not (proc819_5 73)) (global2 setScript: delCapture))
	)
)

(procedure (localproc_0167 param1 param2 param3 param4)
	(if (== argc 5) (manta hide:))
	(whale
		view: param1
		loop: param2
		cel: 0
		posn: param3 param4
		cycleSpeed: 12
		setCycle: End bigFight
	)
)

(procedure (localproc_01a1 param1 param2 param3)
	(manta
		view: 588
		setLoop: Grooper
		loop: param3
		cel: 0
		posn: param1 param2
		ignoreHorizon: 1
		cycleSpeed: 12
		show:
		setCycle: Walk
	)
)

(procedure (localproc_01da param1)
	(EcoNarrator init: 3 0 0 param1 self)
)

(instance rm580 of EcoRoom
	(properties
		picture 580
		style $8007
		horizon 10
		south 560
	)
	
	(method (init)
		(= global250 1)
		(= global251 1)
		(gFeatures
			add:
				mantaLair
				coral
				cactusPlant
				harpoonGun
				harpoonNozzle
				brokenHull
				rockyLedge
				hornPlant
				boat
				doorWay
				shipExit
			eachElementDo: #init
		)
		(if (proc819_5 98)
			(cabinDoor cel: 1 init:)
			(if (proc819_5 71)
				(shipPoly points: @local98 size: 25)
			else
				(shipPoly points: @local0 size: 25)
			)
			(if (not (proc819_5 341)) (cable3 init:))
		else
			(cabinDoor cel: 0 init:)
			(shipPoly points: @local50 size: 24)
			(cable1 init:)
			(cable2 init:)
			(cable3
				view: 580
				loop: 4
				cel: 2
				posn: 93 121
				setPri: 15
				init:
			)
		)
		(if (not (proc819_5 73))
			(proc819_7)
			(gDelph
				z: 0
				ignoreHorizon: 1
				ignoreActors:
				posn: 243 230
				init:
			)
		)
		(super init: &rest)
		(self setRegions: 51 50)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						175
						136
						245
						136
						316
						125
						316
						-10
						319
						-10
						319
						189
						227
						189
						229
						188
						310
						162
						311
						140
						254
						148
						245
						158
						192
						158
					yourself:
				)
				shipPoly
		)
		(cond 
			((== gSouth 600)
				(cond 
					((and (proc819_5 88) (not (proc819_5 135))) (global2 setScript: startBigFight))
					(
						(and
							(proc819_5 88)
							(not (proc819_5 100))
							(not (proc819_5 71))
						)
						(proc958_0 128 588 589 583 581 587 644)
						(whale init: setScript: bigFight)
						(self setScript: fromLairScript)
					)
					((and (proc819_5 88) (not (proc819_5 100)))
						(proc958_0 128 588 589 583 581 587)
						(whale
							view: 589
							loop: 4
							cel: 0
							x: 140
							y: 51
							init:
							setScript: finalFight
						)
						(self setScript: fromLairScript)
					)
					(else (self setScript: fromLairScript))
				)
			)
			((== gSouth 620) (self setScript: outOfShipScript))
			((and (proc819_5 88) (not (proc819_5 135))) (global2 setScript: startBigFight))
			((and (proc819_5 88) (not (proc819_5 71)))
				(proc958_0 128 588 589 583 581 587)
				(whale init: setScript: bigFight)
				(self setScript: fromCavesScript)
			)
			((proc819_5 88)
				(proc958_0 128 588 589 583 581 587)
				(whale
					view: 589
					loop: 4
					cel: 0
					x: 140
					y: 51
					init:
					setScript: finalFight
				)
				(self setScript: fromCavesScript)
			)
			(else (self setScript: fromCavesScript))
		)
		(if
			(and
				(!= gSouth 600)
				(not (proc819_5 71))
				(or (not (proc819_5 135)) (proc819_5 100))
				(or
					(!= (gLongSong number?) 420)
					(== (gLongSong prevSignal?) -1)
				)
			)
			(gLongSong number: 420 loop: -1 play:)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((gEgo inRect: 250 20 296 83) (localproc_00f0))
			((& (gEgo onControl: 1) $0800) (global2 setScript: intoShipScript))
			((== (gEgo edgeHit?) 1) (global2 setScript: cantGoThatWay))
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator store: 75 init: 1 0 0 74)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gEgo setScript: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance fromLairScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo
					view: 809
					loop: 3
					cel: 0
					x: 275
					y: 39
					cycleSpeed: 10
					init:
					setCycle: 0
					setCycle: CT 13 1 self
				)
			)
			(1
				(proc819_6)
				(gEgo
					loop: 2
					x: 276
					y: 42
					setPri: 11
					ignoreHorizon: 1
					setMotion: PolyPath 143 130 self
				)
			)
			(2
				(if (proc819_5 71)
					(shipPoly points: @local98 size: 25)
					(gEgo setMotion: MoveTo 155 114 self)
				else
					(gEgo setHeading: 0)
					(proc0_2)
					(self dispose:)
				)
			)
			(3
				(gEgo setHeading: 0)
				(proc0_2)
				(gIconBar disable: (gIconBar at: 0))
				(if (== (gIconBar curIcon?) (gIconBar at: 0))
					(gIconBar curIcon: (gIconBar at: 1))
					(gGame setCursor: ((gIconBar curIcon?) cursor?))
				)
				(self dispose:)
			)
		)
	)
)

(instance fromCavesScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setSpeed: 7)
				(proc0_1)
				(if (proc819_5 73)
					(= cycles (= cycles 1))
				else
					(gDelph setMotion: MoveTo 173 144 self)
				)
			)
			(1
				(proc819_6)
				(gEgo
					x: 220
					y: 240
					init:
					ignoreHorizon: 1
					setMotion: MoveTo 200 160 self
				)
			)
			(2
				(if (not (proc819_5 73))
					(gDelph setMotion: PolyPath 266 114 self)
				else
					(= cycles (= cycles 1))
				)
			)
			(3
				(cond 
					((not (proc819_5 73))
						(proc819_9 gDelph gEgo)
						(gDelph setPri: 3)
						(proc0_2)
						(self dispose:)
					)
					((proc819_5 71) (gEgo setMotion: MoveTo 155 114 self))
					(else (proc0_2) (self dispose:))
				)
			)
			(4
				(gEgo setHeading: 0)
				(proc0_2)
				(gIconBar disable: (gIconBar at: 0))
				(if (== (gIconBar curIcon?) (gIconBar at: 0))
					(gIconBar curIcon: (gIconBar at: 1))
					(gGame setCursor: ((gIconBar curIcon?) cursor?))
				)
				(self dispose:)
			)
		)
	)
)

(instance exitToLair of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(EcoNarrator init: 1 0 0 84 self)
			)
			(1
				(if
					(and
						(> 261 (gEgo x?))
						(> (gEgo x?) 275)
						(> 46 (gEgo y?))
						(> (gEgo y?) 48)
					)
					(= cycles (= cycles 1))
				else
					(gEgo setMotion: PolyPath 275 60 self)
				)
			)
			(2
				(gEgo setMotion: MoveTo 275 52 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 101
					setLoop: 0
					cel: 4
					x: 271
					y: 41
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4 (global2 newRoom: 600))
		)
	)
)

(instance outOfShipScript of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc819_6)
				(gEgo
					setPri: 7
					posn: 10 90
					init:
					ignoreHorizon: 1
					setMotion: MoveTo 63 125 self
				)
				(if (not (proc819_5 85))
					(gEgo setScript: whaleSoundScript)
				)
			)
			(1 (gEgo setHeading: 45 self))
			(2
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance intoShipScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(cond 
					((proc819_5 88) (EcoNarrator init: 1 0 0 59 self) (= state (= state 2)))
					((& (gEgo onControl: 1) $0800) (= cycles (= cycles 1)))
					(else (gEgo setMotion: PolyPath 50 111 self))
				)
			)
			(1
				(gEgo setPri: 7 setMotion: MoveTo -4 84 self)
			)
			(2
				(proc0_4 5 338)
				(global2 newRoom: 620)
			)
			(3
				(if (not (& (gEgo onControl: 1) $0800))
					(proc0_2)
					(= state (= state 5))
					(= cycles (= cycles 1))
				else
					(gEgo setMotion: PolyPath 63 125 self)
				)
			)
			(4 (gEgo setHeading: 45 self))
			(5
				(proc0_2)
				(= state (= state 6))
				(= cycles (= cycles 1))
			)
			(6
				(if (proc819_5 71) (gIconBar disable: 0))
				(= cycles (= cycles 1))
			)
			(7 (self dispose:))
		)
	)
)

(instance delCapture of HandsOffScript
	(properties)
	
	(method (changeState newState &tmp [temp0 500] temp500)
		(switch (= state (= state newState))
			(0
				(gLongSong number: 580 loop: -1 play:)
				(EcoNarrator init: 1 0 0 86 self)
			)
			(1
				(gEgo setMotion: PolyPath 251 78 self)
			)
			(2
				(proc819_9 gDelph gEgo)
				(gDelph setPri: 3)
				(gEgo setHeading: 180)
				(= seconds (= seconds 3))
			)
			(3
				(manta view: 580 loop: 6 cel: 1 posn: 273 34 init:)
				(= seconds (= seconds 3))
			)
			(4
				(EcoNarrator init: 1 0 0 90 self)
			)
			(5
				(EcoNarrator init: 1 0 0 92 self)
			)
			(6 (gEgo setHeading: 0 self))
			(7
				(manta cycleSpeed: 20 setCycle: End self)
			)
			(8
				(EcoNarrator init: 1 0 0 93 self)
			)
			(9
				(gLongSong number: 340 loop: -1 play:)
				(gEgo setPri: 3 setMotion: DPath 112 32 60 32 self)
				(gDelph setMotion: DPath 116 64 64 56 self)
			)
			(10 0)
			(11
				(gEgo hide:)
				(manta
					view: 603
					setLoop: 0
					cel: 0
					x: local148
					y: [local156 (gDelph hide:)]
				)
				(Animate (gCast elements?) 1)
				(= temp500 1)
				(while (< temp500 8)
					(manta
						x: [local148 temp500]
						y: [local156 (Wait 10)]
						cel: (Wait 0)
					)
					(Animate (gCast elements?) 1)
					(++ temp500)
				)
				(manta hide:)
				(Animate (gCast elements?) 1)
				(global2 newRoom: 345)
			)
		)
	)
)

(instance tryToPryOpenDoor of HandsOffScript
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state (= state newState))
			(0
				(gEgo setMotion: PolyPath 75 100 self)
			)
			(1
				(gEgo setMotion: MoveTo 73 100 self)
			)
			(2
				((gEgo looper?) dispose:)
				(gEgo setCycle: 0 looper: 0)
				(= cycles (= cycles 1))
			)
			(3
				(gEgo
					view: 581
					setLoop: 5
					cel: 0
					x: 43
					y: 103
					cycleSpeed: 17
					setCycle: End self
				)
			)
			(4
				(gEgo setMotion: MoveTo 50 103 self)
			)
			(5
				(proc819_6)
				(gEgo x: 74 y: 105 ignoreHorizon: 1)
				(= cycles (= cycles 1))
			)
			(6
				((ScriptID 2 1) init: 4 0 0 5)
				(self dispose:)
			)
		)
	)
)

(instance pryOpenDoor of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(proc0_4 5 336)
				(gEgo setPri: 13 setMotion: PolyPath 15 134 self)
			)
			(1
				(gEgo setMotion: MoveTo 15 114 self)
			)
			(2 (= cycles (= cycles 12)))
			(3
				(EcoNarrator init: 1 0 0 24 self)
			)
			(4
				((global2 obstacles?) delete: shipPoly)
				(gEgo
					setCycle: 0
					view: 581
					loop: 0
					cel: 0
					posn: 17 118
					cycleSpeed: 18
					setCycle: ForwardCounter 3 self
				)
			)
			(5
				(EcoNarrator posn: -1 20 init: 1 0 0 25 self)
			)
			(6
				(cable1 dispose:)
				(cable2 dispose:)
				(cabinDoor cel: 1 forceUpd:)
				(shipPoly points: @local0 size: 25)
				(proc819_3 98)
				(gEgo
					view: 581
					loop: 1
					cel: 0
					posn: 17 118
					setCycle: End self
				)
				(gSoundEffects number: 584 loop: 1 play:)
				(cable3
					view: 580
					loop: 5
					setPri: 14
					cel: 0
					posn: 88 83
					cycleSpeed: 8
					setCycle: ForwardCounter 4 self
				)
			)
			(7
				(gEgo setScript: whaleSoundScript)
				0
			)
			(8
				(cable3
					view: 580
					loop: 4
					cel: 3
					posn: 25 17
					setPri: 14
					ignoreActors:
				)
				(= cycles (= cycles 1))
			)
			(9
				(EcoNarrator posn: -1 20 init: 1 0 0 26 self)
			)
			(10 (= cycles (= cycles 2)))
			(11
				(EcoNarrator posn: -1 20 init: 1 0 0 27)
				(proc819_6)
				(gEgo ignoreHorizon: 1 setPri: 13 posn: 2 110)
				((global2 obstacles?) add: shipPoly)
				(= cycles (= cycles 12))
			)
			(12
				(gEgo cycleSpeed: 10 setMotion: MoveTo 43 139 self)
			)
			(13
				(EcoNarrator init: 1 0 0 28 self)
			)
			(14
				(EcoNarrator init: 1 0 0 29 self)
			)
			(15
				(gEgo setPri: -1 setScript: whaleSoundScript)
				(= cycles (= cycles 2))
			)
			(16 (gEgo setHeading: 0 self))
			(17 (proc0_2) (self dispose:))
		)
	)
)

(instance startBigFight of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(whale
					x: 0
					y: 56
					view: 589
					setLoop: 4
					cel: 0
					init:
					setCycle: Fwd
				)
				(= cycles (= cycles 1))
			)
			(1
				(whale setMotion: MoveTo 129 56 self)
				(gEgo
					view: 809
					setLoop: 3
					cel: 0
					x: 0
					y: 65
					init:
					setCycle: 0
					posn: 0 65
					moveSpeed: 6
					cycleSpeed: 7
					setMotion: MoveTo 129 65 self
				)
			)
			(2 0)
			(3
				(gEgo
					view: 809
					setLoop: 3
					cel: 0
					setCycle: End self
					setMotion: MoveTo 186 99 self
				)
			)
			(4 0)
			(5
				(proc819_6)
				(gEgo ignoreHorizon: 1)
				(= cycles (= cycles 3))
			)
			(6
				(gEgo setHeading: 0)
				(= cycles (= cycles 4))
			)
			(7
				(localproc_01da 1)
				(= cycles (= cycles 1))
			)
			(8
				(gSoundEffects number: 646 loop: 1 play: self)
			)
			(9
				(whale setScript: bigFight)
				(self dispose:)
			)
		)
	)
)

(instance bigFight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(if
				(or (!= (gLongSong number?) 665) (not (proc819_5 71)))
					(gLongSong number: 664 loop: -1 hold: 0 play:)
				)
				(if (not (proc819_5 135))
					(proc819_3 135)
					(manta
						init:
						setLoop: Grooper
						setPri: 1
						view: 590
						moveSpeed: 3
						loop: 0
						cel: 0
						x: 175
						y: 26
						setCycle: End self
					)
				else
					(manta
						init:
						moveSpeed: 3
						setLoop: Grooper
						setCycle: Fwd
						setPri: 1
						hide:
					)
					(= cycles (= cycles 1))
				)
			)
			(1
				(manta setCycle: Fwd hide:)
				(whale
					view: 583
					loop: 0
					cel: 0
					posn: 152 57
					setPri: 1
					ignoreActors:
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(whale
					view: 589
					loop: 4
					cel: 0
					x: 129
					y: 57
					setCycle: Fwd
				)
				(localproc_01a1 172 22 4)
				(manta setMotion: DPath 223 63 218 77 164 75 self)
			)
			(3
				(whale loop: 0 cel: 0 setCycle: End)
				(manta setMotion: DPath 111 64 89 36 129 7 self)
			)
			(4
				(whale
					x: 143
					y: 56
					view: 583
					loop: 7
					cel: 3
					setCycle: Beg self
				)
				(manta setMotion: DPath 146 24 134 33 self)
			)
			(5 (whale setCycle: End self))
			(6
				(localproc_0167 583 1 151 62 1)
			)
			(7
				(whale
					view: 589
					setLoop: 5
					cel: 0
					x: 149
					y: 61
					setCycle: Fwd
					setMotion: MoveTo 128 56
				)
				(localproc_01a1 130 33 0)
				(manta setMotion: DPath 195 10 262 30 192 46 self)
			)
			(8
				(localproc_0167 583 3 135 36 1)
			)
			(9
				(whale
					view: 589
					loop: 5
					cel: 0
					x: 128
					y: 56
					setCycle: Fwd
				)
				(localproc_01a1 72 73 1)
				(manta setMotion: DPath 136 108 151 101 144 81 self)
			)
			(10
				(localproc_0167 583 5 127 56 1)
			)
			(11
				(whale
					view: 589
					loop: 5
					cel: 0
					x: 140
					y: 54
					setCycle: Fwd
				)
				(localproc_01a1 124 31 1)
				(manta setMotion: DPath 87 32 136 15 self)
			)
			(12
				(whale x: 139 loop: 1 cel: 0 setCycle: End self)
				(manta setMotion: DPath 191 14 208 44 125 105 77 54 self)
			)
			(13
				(whale x: 140 y: 57 loop: 4 setCycle: Fwd)
			)
			(14
				(localproc_0167 583 2 156 37 1)
			)
			(15
				(whale
					view: 589
					setLoop: 4
					cel: 0
					x: 128
					y: 60
					setCycle: Fwd
				)
				(localproc_01a1 203 48 1)
				(manta setMotion: DPath 136 73 85 72 139 113 150 83 self)
			)
			(16
				(localproc_0167 583 4 139 58 1)
			)
			(17
				(whale
					view: 589
					loop: 4
					cel: 0
					x: 129
					y: 56
					setCycle: Fwd
				)
				(localproc_01a1 170 33 0)
				(manta
					setMotion: DPath 194 43 244 90 296 50 292 20 149 5 138 15 152 29 self
				)
			)
			(18
				(manta hide:)
				(= state (= state 0))
				(= cycles (= cycles 1))
			)
		)
	)
)

(instance finalFight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(manta
					init:
					moveSpeed: 2
					setLoop: Grooper
					setPri: 1
					setCycle: Fwd
					hide:
				)
				(= cycles (= cycles 1))
			)
			(1
				(whale
					x: 140
					y: 51
					view: 589
					loop: 4
					cel: 0
					setCycle: Fwd
				)
				(manta
					x: 187
					y: 17
					view: 588
					loop: 4
					cel: 0
					show:
					setMotion: DPath 218 47 248 60 282 57 303 43 302 36 298 23 self
				)
			)
			(2
				(if local164
					(manta setMotion: MoveTo 279 13 self)
				else
					(global2 setScript: endOfFight)
				)
			)
			(3
				(manta setMotion: DPath 210 12 194 19 175 32 self)
			)
			(4
				(if (and (== (gEgo script?) stickManta) local164)
					((gEgo script?) cue:)
				)
				(manta hide:)
				(whale
					view: 583
					loop: 0
					cel: 2
					x: 165
					y: 52
					setCycle: End self
				)
			)
			(5
				(= state (= state 0))
				(self cue:)
			)
			(6
				(manta setMotion: DPath 249 25 226 51 206 45 self)
			)
		)
	)
)

(instance endOfFight of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(EcoNarrator init: 1 0 0 56 self)
			)
			(1
				(manta setMotion: DPath 249 25 226 51 206 45 self)
			)
			(2
				(manta hide:)
				(whale
					view: 583
					loop: 10
					cel: 0
					posn: 173 57
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(EcoNarrator init: 1 0 0 57 self)
			)
			(4
				(whale
					view: 583
					loop: 6
					cel: 0
					x: 153
					y: 45
					setCycle: End
				)
				(manta
					view: 583
					setLoop: 9
					cel: 0
					x: 180
					y: 61
					show:
					setCycle: End self
				)
			)
			(5
				(gLongSong number: 667 loop: -1 play:)
				(EcoNarrator init: 1 0 0 58 self)
			)
			(6
				(manta cel: 1 x: 174 y: 91 setCycle: End self)
				(whale
					view: 589
					loop: 4
					cel: 0
					x: 140
					y: 49
					setCycle: Fwd
				)
			)
			(7
				(manta cel: 1 x: 168 y: 122 setCycle: CT 4 1 self)
			)
			(8
				(proc819_3 100)
				(ShakeScreen 5 1)
				(= cycles (= cycles 15))
			)
			(9
				(proc819_7)
				(gDelph
					z: 0
					ignoreHorizon: 1
					ignoreActors:
					posn: 243 230
					init:
					setMotion: PolyPath 230 110 self
				)
			)
			(10
				((ScriptID 2 0) init: 2 0 0 5 1 self)
			)
			(11
				(localproc_01da 3)
				(= cycles (= cycles 1))
			)
			(12
				(localproc_01da 4)
				((ScriptID 2 0) init: 2 0 0 6 1 self)
			)
			(13
				(localproc_01da 5)
				(= cycles (= cycles 1))
			)
			(14 (global2 newRoom: 101))
		)
	)
)

(instance stickManta of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(EcoNarrator init: 1 0 0 51 self)
			)
			(1 (gEgo setCycle: 0))
			(2
				(gEgo
					view: 581
					setLoop: 2
					setPri: 15
					cel: 0
					x: 181
					y: 98
					setMotion: MoveTo 218 47
					setCycle: CT 10 1 self
				)
			)
			(3
				(gEgo setCycle: RangeOsc -1 11 13)
				(= cycles (= cycles 1))
			)
			(4
				(if
					(not
						(if (< (Abs (- (gEgo x?) (manta x?))) 3)
							(< (Abs (- (gEgo y?) (manta y?))) 3)
						)
					)
					(= state (= state (- state 1)))
					(= cycles (= cycles 1))
				else
					(= local164 0)
					(= cycles (= cycles 1))
				)
			)
			(5
				(EcoNarrator init: 1 0 0 54 self)
			)
			(6
				(EcoNarrator init: 1 0 0 55 self)
			)
			(7
				(gSoundEffects number: 583 loop: 1 play: self)
			)
			(8
				(proc0_4 20 337)
				(gEgo
					put: 21
					view: 809
					setLoop: 3
					cel: 0
					x: (+ (gEgo x?) 4)
					y: (+ (gEgo y?) 5)
					cycleSpeed: 8
					moveSpeed: 6
					setCycle: End self
				)
			)
			(9
				(proc819_6)
				(gEgo setMotion: MoveTo 179 108 self)
			)
			(10 (gEgo setHeading: 0 self))
			(11 (self dispose:))
		)
	)
)

(instance tryToStabManta of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(EcoNarrator init: 1 0 0 51 self)
			)
			(1
				(gEgo setCycle: 0)
				(= cycles (= cycles 1))
			)
			(2
				(if (mod (manta cel?) 2)
					(= temp1 (- (manta x?) 15))
				else
					(= temp1 (+ (manta x?) 15))
				)
				(gEgo
					view: 581
					setLoop: 2
					setPri: 15
					cel: 0
					x: 181
					y: 98
					setMotion: MoveTo temp1 (+ (manta y?) 10)
					setCycle: CT 10 1 self
				)
			)
			(3
				(gEgo setCycle: RangeOsc -1 11 13 moveSpeed: 2)
				(= cycles (= cycles 1))
			)
			(4
				(if
					(or
						(and
							(IsObject (manta mover?))
							(< 177 ((manta mover?) x?))
							(< ((manta mover?) x?) 314)
							(< 9 ((manta mover?) y?))
							(< ((manta mover?) y?) 107)
						)
						(> register 30)
					)
					(gEgo setMotion: MoveTo (manta x?) (manta y?))
					(= cycles (= cycles 2))
				else
					(++ register)
					(= state (= state (- state 1)))
					(= cycles (= cycles 1))
				)
			)
			(5
				(if
					(not
						(if (< (Abs (- (gEgo x?) (manta x?))) 3)
							(< (Abs (- (gEgo y?) (manta y?))) 3)
						)
					)
					(= state (= state (- state 2)))
					(= cycles (= cycles 1))
				else
					(= cycles (= cycles 1))
				)
			)
			(6
				(= register (= register 0))
				(EcoNarrator init: 1 0 0 52 self)
			)
			(7
				(gEgo
					view: 587
					setLoop: 0
					cel: 0
					x: (+ (gEgo x?) 4)
					y: (+ (gEgo y?) 3)
					setPri: 3
					moveSpeed: 6
					cycleSpeed: 6
					setCycle: CT 9 1 self
					setMotion: MoveTo 179 108
				)
			)
			(8
				(gEgo
					view: 644
					setLoop: 0
					cel: 2
					x: (gEgo x?)
					y: (gEgo y?)
					setCycle: Walk
					setMotion: MoveTo 179 108 self
				)
			)
			(9
				(EcoNarrator init: 1 0 0 53 self)
			)
			(10
				(proc819_6)
				(gEgo setHeading: 0 self)
			)
			(11
				(proc0_2)
				(gIconBar disable: (gIconBar at: 0))
				(if (== (gIconBar curIcon?) (gIconBar at: 0))
					(gIconBar curIcon: (gIconBar at: 1))
					(gGame setCursor: ((gIconBar curIcon?) cursor?))
				)
				(self dispose:)
			)
		)
	)
)

(instance smackedByManta of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(EcoNarrator init: 1 0 0 30 self)
			)
			(1
				(gEgo setMotion: PolyPath 243 58 self)
			)
			(2 (= cycles (= cycles 12)))
			(3
				(gEgo
					setCycle: 0
					view: 101
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(4
				(manta
					view: 587
					loop: 1
					cel: 0
					posn: 265 40
					cycleSpeed: 12
					init:
					setCycle: CT 5 1
				)
				(gEgo setCycle: End self)
			)
			(5
				(manta setCycle: End self)
				(gEgo
					view: 587
					loop: 0
					cel: 0
					posn: 246 50
					setCycle: End self
				)
			)
			(6
				(EcoNarrator init: 1 0 0 31 self)
			)
			(7
				(manta dispose:)
				(= cycles (= cycles 1))
			)
			(8 0)
			(9
				(proc819_6)
				(gEgo posn: 246 50 ignoreHorizon: 1)
				(= cycles (= cycles 3))
			)
			(10
				(EcoNarrator init: 1 0 0 32)
				(self dispose:)
			)
		)
	)
)

(instance whaleSoundScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(whaleSound loop: 1 play: self)
			)
			(1
				(= state (= state -1))
				(= seconds (= seconds 8))
			)
		)
	)
)

(instance whaleSound of Sound
	(properties
		number 647
	)
)

(instance cantGoThatWay of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(= cycles (= cycles 1))
			)
			(1
				(EcoNarrator init: 1 0 0 11 self)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 7) self)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance mantaLair of EcoFeature
	(properties
		onMeCheck $0020
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
					(EcoNarrator init: 1 0 0 15)
				else
					(EcoNarrator init: 1 0 0 14)
				)
			)
			(4
				(if (proc819_5 71)
					(EcoNarrator init: 1 0 0 85)
				else
					(localproc_00f0)
				)
			)
			(2 (EcoNarrator init: 1 0 0 63))
			(44
				(EcoNarrator init: 1 0 0 64)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance coral of EcoFeature
	(properties
		onMeCheck $0040
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 10))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cactusPlant of EcoFeature
	(properties
		onMeCheck $0008
		lookStr 17
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 17))
			(4 (EcoNarrator init: 1 0 0 65))
			(44
				(EcoNarrator init: 1 0 0 66)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance harpoonGun of EcoFeature
	(properties
		onMeCheck $0002
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
				(if (not (proc819_5 341)) (EcoNarrator store: 94))
				(EcoNarrator init: 1 0 0 4)
			)
			(4 (EcoNarrator init: 1 0 0 13))
			(44
				(EcoNarrator init: 1 0 0 70)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance brokenHull of EcoFeature
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
			(1 (EcoNarrator init: 1 0 0 19))
			(4 (EcoNarrator init: 1 0 0 20))
			(44
				(EcoNarrator init: 1 0 0 67)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance rockyLedge of EcoFeature
	(properties
		onMeCheck $0100
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 10))
			(4 (EcoNarrator init: 1 0 0 12))
			(44
				(EcoNarrator init: 1 0 0 73)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance hornPlant of EcoFeature
	(properties
		onMeCheck $0010
		lookStr 18
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 65))
			(44
				(EcoNarrator init: 1 0 0 66)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance harpoonNozzle of EcoFeature
	(properties
		onMeCheck $0004
	)
	
	(method (doVerb theVerb)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boat of EcoFeature
	(properties
		onMeCheck $0400
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x ((User curEvent?) x?)))
		(= y (= y ((User curEvent?) y?)))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 3))
			(44
				(EcoNarrator init: 1 0 0 72)
			)
			(4 (EcoNarrator init: 1 0 0 71))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance doorWay of EcoFeature
	(properties
		onMeCheck $1000
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
				(if (proc819_5 88)
					(EcoNarrator init: 1 0 0 34)
				else
					(EcoNarrator init: 1 0 0 33)
				)
			)
			(4
				(global2 setScript: intoShipScript)
			)
			(2 (EcoNarrator init: 1 0 0 76))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (onMe)
		(return (if (cabinDoor cel?) (super onMe: &rest) else 0))
	)
)

(instance shipExit of EcoFeature
	(properties
		onMeCheck $0800
	)
	
	(method (doVerb theVerb &tmp temp0)
		(doorWay doVerb: theVerb temp0 &rest)
	)
)

(instance cabinDoor of EcoView
	(properties
		x 47
		y 98
		view 581
		loop 3
		priority 6
		signal $4011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(cond 
					((not (proc819_5 98)) (EcoNarrator store: 61 init: 1 0 0 1))
					((proc819_5 88) (EcoNarrator init: 1 0 0 34))
					(else (EcoNarrator init: 1 0 0 33))
				)
			)
			(4
				(if (not cel) (global2 setScript: tryToPryOpenDoor))
			)
			(2
				(if (proc819_5 98)
					(EcoNarrator init: 1 0 0 76)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(44
				(cond 
					((== temp0 29)
						(if (not (proc819_5 98))
							(if (not (proc819_5 73))
								(global2 setScript: delCapture)
							else
								(global2 setScript: pryOpenDoor)
							)
						else
							(EcoNarrator init: 1 0 0 77)
						)
					)
					((not (proc819_5 98)) (EcoNarrator init: 1 0 0 81))
					(else (EcoNarrator init: 1 0 0 77))
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance whale of EcoActor
	(properties
		x 152
		y 57
		view 583
		priority 1
		signal $4010
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (not (proc819_5 100))
					(if (proc819_5 71)
						(EcoNarrator init: 1 0 0 36)
					else
						(EcoNarrator store: 36 init: 1 0 0 35)
					)
				)
			)
			(4
				(if (not (proc819_5 100)) (EcoNarrator init: 1 0 0 38))
			)
			(2
				(if (not (proc819_5 100))
					(if (proc819_5 71)
						(EcoNarrator init: 1 0 0 37)
					else
						(localproc_01da 1)
					)
				)
			)
			(44
				(switch temp0
					(30
						(EcoNarrator init: 1 0 0 78)
					)
					(12
						(EcoNarrator init: 1 0 0 79)
					)
					(else 
						(EcoNarrator init: 1 0 0 80)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance manta of EcoActor
	(properties
		view 588
		signal $4000
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator store: 42 init: 1 0 0 41)
			)
			(4
				(if (not (proc819_5 71))
					(localproc_01da 2)
				else
					(EcoNarrator init: 1 0 0 43)
				)
			)
			(2 (EcoNarrator init: 1 0 0 39))
			(6 (EcoNarrator init: 1 0 0 44))
			(44
				(if (proc819_5 71)
					(switch temp0
						(30
							(if (== ((whale script?) state?) 3)
								(gEgo setScript: stickManta)
							else
								(gEgo setScript: tryToStabManta)
							)
						)
						(29
							(EcoNarrator init: 1 0 0 45)
						)
						(37
							(EcoNarrator init: 1 0 0 46)
						)
						(17
							(EcoNarrator init: 1 0 0 48)
						)
						(12
							(EcoNarrator init: 1 0 0 50)
						)
						(else 
							(EcoNarrator init: 1 0 0 49)
						)
					)
				else
					(localproc_01da 2)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance cable1 of EcoView
	(properties
		x 44
		y 43
		view 580
		loop 4
		priority 4
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator store: 60 init: 1 0 0 5)
			)
			(4 (EcoNarrator init: 1 0 0 11))
			(44
				(EcoNarrator init: 1 0 0 69)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance cable2 of EcoView
	(properties
		x 63
		y 79
		view 580
		loop 4
		cel 1
		priority 15
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator store: 60 init: 1 0 0 5)
			)
			(4 (EcoNarrator init: 1 0 0 21))
			(44
				(EcoNarrator init: 1 0 0 69)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance cable3 of EcoProp
	(properties
		x 25
		y 17
		view 580
		loop 4
		cel 3
		priority 14
		signal $5011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 98)
					(EcoNarrator init: 1 0 0 83)
				else
					(EcoNarrator store: 60 init: 1 0 0 5)
				)
			)
			(4
				(if (proc819_5 98)
					(EcoNarrator init: 1 0 0 62)
				else
					(EcoNarrator init: 1 0 0 21)
				)
			)
			(44
				(EcoNarrator init: 1 0 0 69)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance shipPoly of Polygon
	(properties
		type $0002
	)
)
