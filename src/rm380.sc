;;; Sierra Script 1.0 - (do not remove this comment)
(script# 380)
(include sci.sh)
(use Main)
(use EcoRoom)
(use Smopper)
(use n819)
(use EcoFeature)
(use PAvoider)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use n958)
(use Grooper)
(use Jump)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm380 0
	junk 1
	fish 2
	dolphin 3
	tFrisbee 4
	proc380_5 5
	bugEgoScript 6
	fJump 7
	proc380_8 8
	dolphinSwimAbout 11
)

(local
	local0
	local1 =  3
	local2
	local3
	local4
	local5
	local6
	local7
	local8 =  -1
	[local9 69] = [13 14 32 0 3 6 -34 1 3 -8 -34 2 2 17 -31 3 2 -16 -31 2 5 25 -25 3 5 -25 -25 7 3 -20 -30 8 3 20 -30 1 2 -3 -7 0 2 3 -7 3 5 -3 -13 4 5 3 -13]
	[local78 26] = [65 126 78 120 99 112 110 116 112 122 101 128 92 136 78 146 70 153 52 159 40 155 48 143 54 134]
)
(procedure (proc380_5 param1)
	(if argc (dolphin loop: param1))
	(dolphin
		view: 392
		cycleSpeed: global249
		setCycle: Smopper 378
		setLoop: -1
		setLoop: Grooper
		setStep: 2 2
		illegalBits: 0
		moveSpeed: 3
		setAvoider: PAvoider
		z: 0
	)
)

(procedure (proc380_8)
	(gEgo
		z: 0
		loop: 2
		setLoop: Grooper
		setLoop: -1
		setPri: 2
		setMotion: 0
		illegalBits: 0
		ignoreActors: 0
		ignoreHorizon: 1
		view: 379
		setCycle: Walk
		setStep: 2 2
		setSpeed: 16
		cycleSpeed: 15
	)
)

(procedure (localproc_01c2)
	(if
	(and (== (dolphin view?) 394) (== (dolphin loop?) 0))
		(dolphin cel: 5)
	)
	(dolphin
		posn:
			[local78 (* (dolphin cel?) 2)]
			[local78 (+ (* (dolphin cel?) 2) 1)]
	)
)

(instance rm380 of EcoRoom
	(properties
		picture 380
		style $0009
		north 400
		lookStr 1
	)
	
	(method (init &tmp temp0)
		(if (== gSouth 400)
			(UnLoad 129 400)
		else
			(UnLoad 129 320)
		)
		(proc958_0 128 379 380)
		(= global250 5)
		(= global251 1)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						4
						83
						14
						81
						33
						76
						57
						75
						83
						73
						103
						76
						116
						82
						136
						87
						159
						93
						190
						103
						220
						113
						260
						127
						275
						122
						263
						114
						228
						103
						179
						88
						179
						82
						123
						64
						107
						62
						101
						58
						34
						58
						4
						68
					yourself:
				)
				((Polygon new:)
					type: 3
					init: 312 112 259 137 319 158 319 115
					yourself:
				)
				((Polygon new:)
					type: 3
					init:
						6
						109
						4
						139
						53
						175
						138
						141
						172
						163
						211
						146
						191
						137
						176
						143
						151
						132
						194
						123
						102
						98
						69
						89
						35
						95
					yourself:
				)
		)
		(gFeatures
			add:
				bucket
				ladder
				panel
				fishNet
				cabinet
				cages
				boats
				garageDoor
				net
				wall
				lowerWall
				mat
				dock
				water
				safeArea
				pool
				poolFloor
				safeFood
				blackBoard
				starFish
			eachElementDo: #init
		)
		(if (== global87 3)
			(= global249 40)
		else
			(= global249 24)
		)
		(gEgo posn: 73 71)
		(super init: &rest)
		(= temp0
			(cond 
				((< global247 4) 380)
				((< global247 9) 381)
				((< global247 15) 383)
				(else 384)
			)
		)
		(gLongSong number: temp0 loop: -1 play:)
		(if (<= global247 1)
			(dolphin setScript: fromLab)
		else
			(self setScript: fromLab)
		)
	)
	
	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond 
			((or script (gEgo script?)) 0)
			((& (= temp0 (gEgo onControl: 0)) $0020) (self setScript: bounceFromSafeArea))
			((>= (gEgo x?) 315) (self setScript: warnEgo))
			((and (proc819_5 113) (>= (gEgo y?) 150)) (self setScript: bounceFromDel))
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (notify)
		(if (proc819_5 70)
			(EcoNarrator posn: 140 20 init: 5 0 0 134)
		else
			(EcoNarrator posn: 140 20 init: 5 0 0 133)
		)
	)
)

(instance warnEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(EcoNarrator posn: 140 20 init: 6 0 0 36 self)
			)
			(1
				(gEgo setMotion: MoveTo 298 134 self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance bounceFromDel of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(EcoNarrator posn: 140 20 init: 5 0 0 122 self)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x?) 140 self)
			)
			(2
				(proc0_2)
				(proc380_8)
				(self dispose:)
			)
		)
	)
)

(instance bounceFromSafeArea of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 1) init: 2 0 0 41 1 self)
			)
			(1
				(gEgo setMotion: MoveTo 134 129 self)
			)
			(2
				(proc0_2)
				(proc380_8)
				(self dispose:)
			)
		)
	)
)

(instance scareIntoSafeArea of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(= global247 0)
				(dolphin setScript: 0 setMotion: PolyPath 183 143 self)
			)
			(1
				(dolphin setHeading: 45 self)
			)
			(2
				(dolphin
					setCycle: 0
					view: 382
					loop: 3
					cel: 4
					setPri: 14
					posn: 156 165
					setCycle: CT 6 1 self
				)
			)
			(3
				(dolphinLever setCycle: End self)
			)
			(4
				(dolphin setCycle: End self)
				(insideGate startUpd: setCycle: Beg self)
				(gSoundEffects number: 394 loop: 1 play:)
			)
			(5 0)
			(6
				(gSoundEffects stop:)
				(labDoor setScript: 0)
				(insideGate stopUpd:)
				(dolphin loop: 0 cycleSpeed: 36 setCycle: Fwd)
				(= seconds 4)
			)
			(7
				(gCast eachElementDo: #hide)
				(global2 style: 10 drawPic: 901)
				(= seconds 3)
			)
			(8
				(gIconBar enable: 7)
				(if (== gSouth 400)
					(= gNumber 360)
				else
					(= gNumber 361)
				)
				(self dispose:)
			)
		)
	)
)

(instance pickUpFrisbee of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo
					setMotion: PolyPath (tFrisbee approachX?) (tFrisbee approachY?) self
				)
			)
			(1
				(gEgo
					view: 383
					get: 15
					loop: (if (< (gEgo x?) (tFrisbee x?)) 9 else 10)
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(tFrisbee hide: approachVerbs:)
				(gEgo setCycle: End self)
			)
			(3
				(tFrisbee stopUpd:)
				(proc819_6 2)
				(UnLoad 128 383)
				(proc0_2)
				(proc0_5 15)
				(gGame setCursor: ((Inv at: 15) cursor?))
				(self dispose:)
			)
		)
	)
)

(instance getFrisbee of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(proc819_3 122)
				(gEgo setMotion: PolyPath 137 72 self)
			)
			(1 (gEgo setHeading: 45 self))
			(2
				(gEgo
					view: 383
					loop: 2
					cel: 0
					cycleSpeed: 8
					setCycle: CT 1 1 self
				)
			)
			(3
				(EcoNarrator posn: 140 20 init: 5 0 0 87 self)
			)
			(4
				(tFrisbee startUpd: hide:)
				(proc0_4 4 222)
				(gEgo get: 15 setCycle: End self)
			)
			(5
				(tFrisbee
					nsLeft: (- (tFrisbee nsLeft?) 5)
					nsRight: (+ (tFrisbee nsRight?) 5)
					nsTop: (- (tFrisbee nsTop?) 5)
					nsBottom: (+ (tFrisbee nsBottom?) 5)
					stopUpd:
				)
				(proc819_6 5)
				(UnLoad 128 383)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance climbInPool of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 87 80 self)
			)
			(1
				(gEgo setMotion: MoveTo 84 83 self)
			)
			(2 (gEgo setHeading: 45 self))
			(3
				(if (< global247 6) (gLongSong number: 380 play:))
				(gIconBar disable: 7)
				(gEgo
					view: 381
					loop: 0
					cel: 0
					cycleSpeed: 15
					setCycle: CT 6 1 self
				)
			)
			(4
				(gSoundEffects number: 392 loop: 1 play:)
				(gEgo cel: 7 setCycle: End self)
			)
			(5
				(if (>= global247 6)
					(proc0_4 5 238)
					(EcoNarrator posn: 140 20 init: 5 0 0 121 self)
					(labDoor setScript: 0)
				else
					(= ticks 3)
				)
			)
			(6
				(gEgo
					setLoop: 4
					cel: 0
					posn: 74 95
					cycleSpeed: 15
					setCycle: Fwd
					setPri: 3
					setMotion: MoveTo 69 100 self
				)
			)
			(7
				(proc819_3 113)
				(localproc_01c2)
				(proc380_5)
				(proc380_8)
				(dolphin setScript: 0 setAvoider: PAvoider)
				(cond 
					((== global247 6) (self setScript: (ScriptID 59 0) self))
					((> global247 6) (= cycles 3))
					((< global247 6) (self setScript: scareIntoSafeArea))
				)
			)
			(8
				(proc0_2)
				(gIconBar enable: 7)
				(= global247 11)
				(labDoor setScript: (ScriptID 127 0) 0 916)
				(gEgo cycleSpeed: 15 moveSpeed: 15)
				(self dispose:)
			)
		)
	)
)

(instance climbOutPool of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client global2) (proc0_1))
				(gEgo setMotion: PolyPath 69 100 self)
			)
			(1
				(gEgo
					view: 381
					loop: 0
					cel: 12
					posn: 84 83
					setPri: -1
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(2
				(proc819_6 6)
				(gEgo setMotion: MoveTo 94 73 self)
			)
			(3
				(dolphin setMotion: MoveTo 78 120 self)
			)
			(4 (gEgo setHeading: 225 self))
			(5
				(if (== client global2) (proc0_2))
				(= global248 1)
				(dolphin
					setPri: 6
					setCycle: 0
					setScript: dolphinSwimAbout
				)
				(proc819_4 113)
				(self dispose:)
			)
		)
	)
)

(instance climbOutToThrowFrisbee of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(EcoNarrator posn: 140 20 init: 5 0 0 112 self)
			)
			(1
				(self setScript: climbOutPool self)
			)
			(2 (= seconds 3))
			(3
				(self setScript: (ScriptID 61 0) self)
			)
			(4 (proc0_2) (self dispose:))
		)
	)
)

(instance pullLever of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gIconBar disable: 7)
				(proc0_4 10 237)
				(dolphin setScript: 0)
				(gEgo setMotion: PolyPath 204 107 self)
			)
			(1
				(proc819_3 72)
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo
					view: 381
					loop: 5
					cel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(3
				(proc0_4 10 237)
				(gEgo setCycle: End)
				(outsideGateLever
					startUpd:
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(4
				(proc819_6 4)
				(gSoundEffects number: 399 loop: 1 play:)
				(outsideGate setCycle: Beg self)
			)
			(5
				(proc819_9 gEgo dolphin self)
			)
			(6
				(gSoundEffects stop:)
				(outsideGate stopUpd:)
				(proc819_9 dolphin gEgo self)
			)
			(7
				(proc819_9 gEgo dolphin self)
			)
			(8
				((ScriptID 2 1) init: 2 0 0 8 1 self)
			)
			(9
				((ScriptID 2 0) init: 1 0 0 15 1 self)
			)
			(10
				((ScriptID 2 1) init: 2 0 0 9 1 self)
			)
			(11
				((ScriptID 2 0) init: 1 0 0 16 1 self)
			)
			(12
				((ScriptID 2 1) init: 2 0 0 10 1 self)
			)
			(13
				(dolphin setMotion: MoveTo 121 120 self)
			)
			(14
				(proc819_9 gEgo dolphin self)
			)
			(15
				(EcoNarrator posn: 140 20 init: 5 0 0 115 self)
			)
			(16
				(dolphin setCycle: 0 setMotion: MoveTo 216 165 self)
			)
			(17
				(proc819_9 gEgo dolphin self)
			)
			(18
				(gEgo
					view: 381
					loop: 8
					cel: 0
					cycleSpeed: 20
					setCycle: Fwd
				)
				(dolphin
					view: 395
					loop: 0
					cel: 0
					setPri: 14
					posn: 277 189
					setCycle: End self
				)
			)
			(19
				(dolphin dispose:)
				(= seconds 3)
			)
			(20 (global2 newRoom: 381))
		)
	)
)

(instance getFish of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 101 66 self)
			)
			(1 (gEgo setHeading: 90 self))
			(2
				(switch global247
					(4 (proc0_4 2 224))
					(5 (proc0_4 2 225))
				)
				(gEgo
					get: 16
					view: 381
					loop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(3
				(gSoundEffects number: 388 loop: 1 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 88 self)
			)
			(5
				(proc819_6 90)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance fromLab of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo init:)
				(outsideGate init: stopUpd:)
				(dolphinLever init: stopUpd:)
				(labDoor init: stopUpd:)
				(dockDoor init: stopUpd:)
				(outsideGateLever init: stopUpd:)
				(tFrisbee init:)
				(insideGate init: stopUpd:)
				(proc819_6 2)
				(proc819_4 113)
				(proc819_4 70)
				(proc819_4 111)
				(proc819_4 112)
				(cond 
					((<= global247 1) (self setScript: fromLabStateSick self))
					((and (<= 2 global247) (<= global247 14)) (proc0_2) (self setScript: fromLabStateSwimAbout self))
					((and (<= 15 global247) (<= global247 17)) (proc0_2) (self setScript: fromLabStateReadyToLeave self))
				)
			)
			(1 (self dispose:))
		)
	)
)

(instance fromLabStateReadyToLeave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin init: posn: 177 119)
				(proc380_5 0)
				(dolphin setPri: 6 setScript: bugEgoScript)
				(= cycles 1)
			)
			(1
				(labDoor startUpd: setCycle: Beg self)
			)
			(2
				(gSoundEffects number: 902 loop: 1 play:)
				(labDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fromLabStateSwimAbout of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin
					view: 382
					init:
					approachVerbs:
					cycleSpeed: 8
					posn: 63 137
					setPri: 6
					setScript: dolphinSwimAbout
				)
				(= cycles 1)
			)
			(1
				(cond 
					((== gSouth 360) (EcoNarrator posn: 140 20 init: 5 0 0 57 self))
					((== gSouth 361) ((ScriptID 2 1) init: 2 0 0 53 1 self))
					(else (= ticks 3))
				)
			)
			(2
				(labDoor startUpd: setCycle: Beg self)
				(gSoundEffects number: 902 loop: 1 play:)
			)
			(3
				(labDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fromLabStateSick of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin
					view: 382
					loop: 0
					cel: 0
					posn: 145 163
					setPri: 14
					cycleSpeed: global249
					init:
					setCycle: Fwd
				)
				(= cycles 2)
			)
			(1
				(gSoundEffects number: 902 loop: 1 play:)
				(labDoor startUpd: setCycle: Beg self)
			)
			(2 (= seconds 2))
			(3
				(labDoor stopUpd:)
				(cond 
					((== gSouth 400) (EcoNarrator posn: 140 20 init: 5 0 0 7 self))
					((== gSouth 360)
						(= global247 1)
						(EcoNarrator posn: 140 20 init: 5 0 0 57 self)
					)
					(else (= global247 1) ((ScriptID 2 1) init: 2 0 0 53 1 self))
				)
			)
			(4
				(proc0_2)
				(dolphin setCycle: End self)
			)
			(5
				(dolphin
					loop: 5
					cel: 2
					posn: 145 163
					setCycle: CT 6 1 self
				)
			)
			(6
				(dolphin setPri: 6 setCycle: End self)
			)
			(7
				(= global248 6)
				(dolphin
					approachVerbs:
					cycleSpeed: 8
					setScript: dolphinSwimAbout
				)
				(self dispose:)
			)
		)
	)
)

(instance toLab of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 53 63 self)
			)
			(1 (gEgo setHeading: 45 self))
			(2
				(gEgo view: 380 loop: 6 cel: 0 setCycle: CT 1 1 self)
				(gSoundEffects number: 901 loop: 1 play:)
				(labDoor startUpd: setCel: 1)
			)
			(3
				(gEgo setCel: 2)
				(labDoor setCel: 2)
				(= cycles 1)
			)
			(4
				(labDoor setCycle: End)
				(proc819_6 6)
				(gEgo setMotion: MoveTo 73 61 self)
			)
			(5
				(labDoor stopUpd:)
				(gEgo setMotion: MoveTo 73 51 self)
			)
			(6
				(global2 newRoom: 400)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance throwFishBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(dolphin setCycle: CT 3 1 self)
			)
			(1
				(dolphin setCel: 0)
				(gSoundEffects number: 396 loop: 1 play:)
				(fish
					posn: 99 93
					init:
					setLoop: 3
					setCycle: Fwd
					setPri: 3
					setMotion: JumpTo 115 37 self
				)
			)
			(2
				(gSoundEffects number: 389 loop: 1 play:)
				(fish loop: 6 cel: 0 posn: 115 45 setCycle: End self)
			)
			(3
				(fish setLoop: 3 cel: 0 dispose:)
				(= seconds 2)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 45 1 self)
			)
			(5
				(if local1
					(-- local1)
					(= ticks 3)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 38 self)
				)
			)
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance dolphinSwimAbout of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(= seconds 0)
				(dolphin setCycle: 0)
			)
			(1
				(dolphin
					view: 382
					loop: 0
					setMotion: 0
					setCel: global248
					posn: 63 137
					z: 0
					cycleSpeed: global249
				)
				(if (>= global248 5)
					(= state -1)
					(= global248 0)
					(dolphin setCycle: End self)
				else
					(dolphin setCycle: CT 5 1 self)
				)
			)
			(2
				(cond 
					((and (<= 4 global247) (<= global247 10))
						(dolphin
							view: 394
							loop: 0
							cel: 0
							z: 50
							setCycle: 0
							posn: (+ (dolphin x?) 45) (+ (dolphin y?) 41)
						)
						(if (not local3) (= seconds 2) else (= seconds 8))
					)
					((and (<= 11 global247) (<= global247 14))
						(if (not (= local5 (mod (++ local5) 4)))
							(if (or (!= local6 44) (!= global247 11))
								(= local6 44)
							else
								(= local6 45)
							)
							(EcoNarrator posn: 140 20 init: 5 0 0 local6 self)
						else
							(= ticks 3)
						)
					)
					(else (= ticks 3))
				)
			)
			(3
				(if
				(and (not local3) (<= 4 global247) (<= global247 5))
					(EcoNarrator posn: 140 20 init: 5 0 0 74 self)
					(= local3 1)
				else
					(= ticks 3)
				)
			)
			(4
				(if
				(and (< 4 global247) (< global247 6) (not local2))
					(= local2 1)
					(EcoNarrator posn: 140 20 init: 5 0 0 36 self)
				else
					(= ticks 3)
				)
			)
			(5
				(= global248 0)
				(dolphin
					view: 382
					loop: 0
					setCel: 5
					z: 0
					posn: 63 137
					setCycle: End self
				)
				(= state -1)
			)
		)
	)
)

(instance throwFish of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(if
					(= register
						(if (== (dolphin view?) 394) (== (dolphin loop?) 0))
					)
					(dolphin setScript: 0)
				)
				(gEgo setMotion: PolyPath 130 77 self)
			)
			(1
				(gEgo put: 16 setHeading: 180 self)
			)
			(2
				(gEgo
					view: 381
					loop: 2
					cel: 0
					cycleSpeed: 8
					setCycle: CT 6 1 self
				)
			)
			(3
				(fish
					init:
					loop: 3
					posn: 150 55
					setPri: 12
					setCycle: Fwd
					setMotion: JumpTo 98 127 self
				)
				(proc819_6 2)
			)
			(4
				(gSoundEffects number: 389 loop: 1 play:)
				(fish loop: 6 cel: 0 setCycle: End self)
			)
			(5
				(fish dispose:)
				(if register
					(if (proc999_5 global247 4 5)
						(self setScript: eatFish self)
					else
						(self setScript: throwFishBack self)
					)
				else
					(= ticks 3)
				)
			)
			(6
				(cond 
					(register
						(= global248 5)
						(dolphin setScript: dolphinSwimAbout)
						(switch global247
							(4
								(= global247 5)
								(EcoNarrator posn: 140 20 init: 5 0 0 35 self)
							)
							(5
								(= global247 6)
								((ScriptID 2 1) init: 2 0 0 37 1 self)
							)
							(else  (= ticks 3))
						)
					)
					((== global247 2) (EcoNarrator posn: 140 20 init: 5 0 0 73 self))
					((< global247 4) (EcoNarrator posn: 140 20 init: 5 0 0 39 self))
					((and (<= 6 global247) (<= global247 10)) (EcoNarrator posn: 140 20 init: 5 0 0 34 self))
					((and (<= 4 global247) (<= global247 5)) (EcoNarrator posn: 140 20 init: 5 0 0 97 self))
					(else (EcoNarrator posn: 140 20 init: 5 0 0 98 self))
				)
			)
			(7
				(gIconBar curIcon: (gIconBar at: 2))
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance eatFish of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dolphin cycleSpeed: 10 setCycle: CT 2 1 self)
			)
			(1
				(gSoundEffects number: 396 loop: 1 play:)
				(dolphin setCycle: CT 7 1 self)
			)
			(2
				(gSoundEffects number: 397 loop: 1 play:)
				(dolphin cel: 8 setCycle: End self)
			)
			(3
				(switch global247
					(4 (proc0_4 2 229))
					(5 (proc0_4 2 230))
				)
				(self dispose:)
			)
		)
	)
)

(instance bugEgoScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(dolphin setMotion: MoveTo 177 119 self)
			)
			(1
				(dolphin setHeading: 90 self)
			)
			(2
				(proc0_2)
				(gIconBar enable: 7)
				(= cycles 1)
			)
			(3 (= seconds 10))
			(4
				(= state (- state 2))
				(if (not (global2 script?))
					((ScriptID 2 0)
						init: 1 0 0 [local9 (= local8 (mod (++ local8) 3))] 1 self
					)
				else
					(= ticks 3)
				)
			)
		)
	)
)

(instance inDockDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(dockDoor approachX: 250 approachY: 118)
				(gEgo setMotion: PolyPath 271 131 self)
			)
			(1
				(gEgo setHeading: 0 self)
				(proc819_4 70)
			)
			(2
				(gEgo view: 380 setLoop: 7 cel: 0 setCycle: CT 1 1 self)
				(gSoundEffects number: 901 loop: 1 play:)
				(dockDoor startUpd: setCel: 1)
			)
			(3
				(gEgo setCel: 2)
				(dockDoor setCel: 2)
				(= cycles 1)
			)
			(4
				(proc819_6 3)
				(dockDoor setCycle: End self)
			)
			(5
				(gEgo setLoop: -1 setMotion: MoveTo 289 130 self)
			)
			(6
				(gEgo setPri: -1 setMotion: MoveTo 236 110 self)
			)
			(7
				(dockDoor setCycle: Beg self)
			)
			(8
				(gSoundEffects number: 902 loop: 1 play:)
				(dockDoor stopUpd:)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance outDockDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dockDoor approachX: 271 approachY: 138)
				(proc0_1)
				(gEgo setMotion: PolyPath 250 118 self)
			)
			(1
				(proc819_3 70)
				(gSoundEffects number: 901 loop: 1 play:)
				(dockDoor startUpd: setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 307 139 self)
			)
			(3
				(EcoNarrator posn: 140 20 init: 5 0 0 99 self)
			)
			(4
				(dockDoor setCycle: Beg self)
			)
			(5
				(gEgo setPri: 11)
				(gSoundEffects number: 902 loop: 1 play:)
				(dockDoor stopUpd:)
				(= cycles 1)
			)
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance junk of EcoProp
	(properties
		x 151
		y 119
		view 396
		loop 2
		priority 15
		signal $4010
	)
)

(instance outsideGate of EcoProp
	(properties
		x 245
		y 174
		view 396
		loop 1
		signal $4000
		lookStr 23
	)
	
	(method (init)
		(super init: &rest)
		(= cel (self lastCel:))
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 26)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dolphinLever of EcoProp
	(properties
		x 217
		y 145
		view 380
		loop 4
		lookStr 55
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blackBoard of EcoFeature
	(properties
		x 140
		y 37
		nsTop 2
		nsLeft 130
		nsBottom 49
		nsRight 196
		sightAngle 45
		onMeCheck $4000
		approachX 135
		approachY 74
	)
	
	(method (doVerb theVerb)
		(cond 
			(
				(and
					(not (proc819_5 113))
					(not (proc819_5 111))
					(not (proc819_5 70))
				)
				(switch theVerb
					(1
						(global2 setScript: (ScriptID 69 0) 0 -1)
					)
					(4
						(global2 setScript: (ScriptID 69 0) 0 -1)
					)
					(else 
						(super doVerb: theVerb &rest)
					)
				)
			)
			((proc819_5 113)
				(if (== global247 10)
					(EcoNarrator posn: 140 20 init: 5 0 0 92)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 61)
				)
			)
			((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 117))
			((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
		)
	)
)

(instance safeFood of EcoFeature
	(properties
		x 201
		y 127
		nsTop 117
		nsLeft 186
		nsBottom 135
		nsRight 221
		sightAngle 45
		onMeCheck $2000
		lookStr 70
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 58)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance labDoor of EcoProp
	(properties
		x 90
		y 56
		approachX 61
		approachY 62
		view 380
		signal $4000
		cycleSpeed 0
		lookStr 21
	)
	
	(method (init)
		(super init: &rest)
		(if (!= gSouth 320) (self setCel: (self lastCel:)))
		(self
			setScript: (ScriptID 127 0) 0 (+ 916 (* (<= global247 6) 2))
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(cond 
			((== theVerb 1) (EcoNarrator posn: 140 20 init: 5 0 0 lookStr))
			(
				(and
					(not (proc819_5 113))
					(not (proc819_5 111))
					(not (proc819_5 70))
				)
				(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
					(= temp0 theVerb)
					(= theVerb 44)
				)
				(switch theVerb
					(1
						(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
					)
					(4 (global2 setScript: toLab))
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			((proc819_5 113)
				(if (== global247 10)
					(EcoNarrator posn: 140 20 init: 5 0 0 92)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 61)
				)
			)
			((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 117))
			((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
		)
	)
)

(instance dockDoor of EcoProp
	(properties
		x 292
		y 128
		z 60
		approachX 250
		approachY 118
		view 380
		loop 2
		priority 9
		signal $4010
		lookStr 22
	)
	
	(method (init)
		(super init:)
		(if (not (== (Dummy 4 0) 2))
			(self approachVerbs: 4 9)
		)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (User controls?)
			(if
				(and
					(not (global2 script?))
					(!= (pEvent type?) evVERB)
					(self onMe: pEvent)
					(not (pEvent modifiers?))
					(== (gIconBar curIcon?) (gIconBar at: 0))
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
					(not (proc819_5 113))
				)
				(pEvent claimed: 1)
				(self doVerb: 4)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(cond 
			((== theVerb 1) (EcoNarrator posn: 140 20 init: 5 0 0 lookStr))
			(
			(and (not (proc819_5 113)) (not (proc819_5 111)))
				(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
					(= temp0 theVerb)
					(= theVerb 44)
				)
				(switch theVerb
					(4
						(if (proc819_5 70)
							(global2 setScript: inDockDoor)
						else
							(global2 setScript: outDockDoor)
						)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			((proc819_5 113)
				(if (== global247 10)
					(EcoNarrator posn: 140 20 init: 5 0 0 92)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 61)
				)
			)
			((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 117))
		)
	)
)

(instance outsideGateLever of EcoProp
	(properties
		x 212
		y 116
		approachX 204
		approachY 107
		view 380
		loop 3
		signal $4000
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (outsideGate cel?)
					(EcoNarrator posn: 140 20 init: 5 0 0 19)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 71)
				)
			)
			(44
				(EcoNarrator posn: 140 20 init: 5 0 0 132)
			)
			(4
				(cond 
					((not (outsideGate cel?)) (EcoNarrator posn: 140 20 init: 5 0 0 59))
					(
						(and
							(not (proc819_5 113))
							(not (proc819_5 111))
							(not (proc819_5 70))
							(>= global247 15)
						)
						(global2 setScript: pullLever)
					)
					((proc819_5 113)
						(if (== global247 10)
							(EcoNarrator posn: 140 20 init: 5 0 0 92)
						else
							(EcoNarrator posn: 140 20 init: 5 0 0 61)
						)
					)
					((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
					((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 117))
					((< global247 15) (EcoNarrator posn: 140 20 init: 5 0 0 20))
					(else (super doVerb: theVerb temp0 &rest))
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance tFrisbee of EcoActor
	(properties
		x 151
		y 65
		z 20
		approachX 137
		approachY 72
		yStep 3
		view 380
		loop 5
		signal $4000
		xStep 4
		moveSpeed 5
		lookStr 53
	)
	
	(method (init)
		(super init: &rest)
		(cond 
			(
			(or (== ((gInv at: 15) owner?) 360) (gEgo has: 15)) (self hide: stopUpd:))
			((proc819_5 122)
				(self
					posn: global120 global121
					z: 100
					approachX: global122
					approachY: global123
					view: 380
					loop: 5
					cel: 0
					setPri: 1
					show:
					stopUpd:
				)
			)
			(else (self show: stopUpd:))
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if
		(and (not (proc819_5 113)) (not (proc819_5 70)))
			(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
				(= temp0 theVerb)
				(= theVerb 44)
			)
			(switch theVerb
				(1
					(if (proc819_5 122)
						(EcoNarrator posn: 140 20 init: 5 0 0 96)
					else
						(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
					)
				)
				(4
					(if (== view 380)
						(if (and (== x 151) (== y 65))
							(global2 setScript: getFrisbee)
						else
							(global2 setScript: pickUpFrisbee)
						)
					else
						(proc819_3 112)
						(proc0_1)
						(switch global247
							(12 (proc0_4 1 243))
							(13 (proc0_4 1 244))
							(14 (proc0_4 1 245))
							(16 (proc0_4 1 246))
						)
					)
				)
				(else 
					(super doVerb: theVerb temp0 &rest)
				)
			)
		else
			(super doVerb: theVerb temp0 &rest)
		)
	)
	
	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x?))
			(= temp1 (param1 y?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(if
				(and
					(<= nsLeft temp0)
					(<= temp0 nsRight)
					(<= nsTop temp1)
				)
				(<= temp1 nsBottom)
			else
				0
			)
		)
	)
)

(instance fish of EcoActor
	(properties
		view 381
		loop 3
		signal $4000
	)
)

(instance insideGate of EcoProp
	(properties
		x 144
		y 242
		z 100
		view 396
		cel 8
		signal $4000
		cycleSpeed 12
		lookStr 54
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 54)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bucket of EcoFeature
	(properties
		x 104
		y 55
		sightAngle 45
		onMeCheck $0004
		approachX 104
		approachY 66
		lookStr 38
	)
	
	(method (doVerb theVerb &tmp temp0)
		(cond 
			((== theVerb 1) ((ScriptID 2 1) init: 2 0 0 lookStr 1))
			(
				(and
					(not (proc819_5 113))
					(not (proc819_5 111))
					(not (proc819_5 70))
				)
				(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
					(= temp0 theVerb)
					(= theVerb 44)
				)
				(switch theVerb
					(4
						(if (not (gEgo has: 16))
							(global2 setScript: getFish)
						else
							((ScriptID 2 1) init: 2 0 0 39 1)
						)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			((proc819_5 113)
				(if (== global247 10)
					(EcoNarrator posn: 140 20 init: 5 0 0 92)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 61)
				)
			)
			((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 117))
			((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
		)
	)
)

(instance ladder of EcoFeature
	(properties
		sightAngle 45
		onMeCheck $0002
		approachX 87
		approachY 80
		lookStr 18
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(if (!= (dolphin script?) fromLab)
					(cond 
						((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
						((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 102))
						((not (proc819_5 113))
							(if (< global247 8)
								(global2 setScript: climbInPool)
							else
								(EcoNarrator posn: 140 20 init: 5 0 0 101)
							)
						)
						((proc819_5 113)
							(if (== global247 10)
								(EcoNarrator posn: 140 20 init: 5 0 0 106)
							else
								(global2 setScript: climbOutPool)
							)
						)
					)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 103)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance starFish of EcoFeature
	(properties
		x 234
		y 165
		nsTop 156
		nsLeft 204
		nsBottom 176
		nsRight 255
		sightAngle 45
		onMeCheck $0100
		approachX 317
		approachY 136
		lookStr 56
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance panel of EcoFeature
	(properties
		x 6
		y 46
		nsTop 36
		nsBottom 68
		nsRight 20
		sightAngle 45
		onMeCheck $4000
		approachX 10
		approachY 69
		lookStr 12
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(if local4
					(EcoNarrator posn: 140 20 init: 5 0 0 14)
				else
					(++ local4)
					(EcoNarrator posn: 140 20 init: 5 0 0 13)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fishNet of EcoFeature
	(properties
		x 29
		y 16
		nsTop 2
		nsLeft 21
		nsBottom 60
		nsRight 37
		sightAngle 45
		onMeCheck $4000
		approachX 27
		approachY 66
		lookStr 15
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(if (proc819_5 72)
					(EcoNarrator posn: 140 20 init: 5 0 0 17)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 16)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance cabinet of EcoFeature
	(properties
		x 152
		y 52
		nsTop 39
		nsLeft 130
		nsBottom 76
		nsRight 186
		sightAngle 45
		onMeCheck $2000
		approachX 135
		approachY 74
		lookStr 62
	)
	
	(method (doVerb theVerb &tmp temp0)
		(cond 
			(
				(and
					(not (proc819_5 113))
					(not (proc819_5 111))
					(not (proc819_5 70))
				)
				(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
					(= temp0 theVerb)
					(= theVerb 44)
				)
				(switch theVerb
					(4
						(if (gEgo has: 17)
							(EcoNarrator posn: 140 20 init: 5 0 0 60)
						else
							(global2 setScript: (ScriptID 67 0))
						)
					)
					(1
						(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			((proc819_5 113)
				(if (== global247 10)
					(EcoNarrator posn: 140 20 init: 5 0 0 92)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 61)
				)
			)
			((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 117))
			((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
		)
	)
)

(instance cages of EcoFeature
	(properties
		x 218
		y 74
		nsTop 78
		nsLeft 188
		nsBottom 102
		nsRight 235
		sightAngle 45
		onMeCheck $4000
		approachX 201
		approachY 99
	)
	
	(method (doVerb theVerb &tmp temp0)
		(cond 
			(
				(and
					(not (proc819_5 113))
					(not (proc819_5 111))
					(not (proc819_5 70))
				)
				(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
					(= temp0 theVerb)
					(= theVerb 44)
				)
				(switch theVerb
					(1
						(global2 setScript: (ScriptID 69 1) 0 -1)
					)
					(4
						(global2 setScript: (ScriptID 69 1) 0 -1)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			((proc819_5 113)
				(if (== global247 10)
					(EcoNarrator posn: 140 20 init: 5 0 0 92)
				else
					(EcoNarrator posn: 140 20 init: 5 0 0 61)
				)
			)
			((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 117))
			((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
		)
	)
)

(instance boats of EcoFeature
	(properties
		x 228
		y 59
		nsTop 13
		nsLeft 191
		nsBottom 103
		nsRight 279
		sightAngle 45
		onMeCheck $2000
		approachX 201
		approachY 99
		lookStr 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 2)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance garageDoor of EcoFeature
	(properties
		x 228
		y 59
		nsLeft 209
		nsBottom 48
		nsRight 294
		sightAngle 45
		onMeCheck $1000
		approachX 201
		approachY 99
		lookStr 63
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 86)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance net of EcoFeature
	(properties
		x 127
		y 149
		nsTop 104
		nsLeft 39
		nsBottom 189
		nsRight 205
		sightAngle 45
		onMeCheck $1000
		approachX 176
		approachY 93
		lookStr 64
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of EcoFeature
	(properties
		x 222
		y 119
		nsLeft 125
		nsBottom 189
		nsRight 319
		sightAngle 45
		onMeCheck $0800
		approachX 227
		approachY 107
		lookStr 65
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lowerWall of EcoFeature
	(properties
		x 229
		y 110
		nsTop 149
		nsLeft 177
		nsBottom 149
		nsRight 265
		sightAngle 45
		onMeCheck $0400
		approachX 227
		approachY 107
		lookStr 66
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mat of EcoFeature
	(properties
		x 297
		y 119
		nsTop 117
		nsLeft 274
		nsBottom 138
		nsRight 317
		sightAngle 45
		onMeCheck $4000
		approachX 313
		approachY 133
		lookStr 67
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
	
	(method (handleEvent pEvent &tmp temp0)
		(if (User controls?)
			(if
				(and
					(not (global2 script?))
					(!= (pEvent type?) evVERB)
					(self onMe: pEvent)
					(not (pEvent modifiers?))
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
					(== (gIconBar curIcon?) (gIconBar at: 0))
				)
				(if (not (proc819_5 70))
					(if (not (proc819_5 113))
						(pEvent claimed: 1)
						(dockDoor doVerb: 4)
					else
						(pEvent claimed: 1)
						(ladder doVerb: 4)
					)
				else
					(super handleEvent: pEvent &rest)
				)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poolFloor of EcoFeature
	(properties
		x 104
		y 55
		sightAngle 45
		onMeCheck $0040
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
	
	(method (handleEvent pEvent &tmp temp0)
		(if (User controls?)
			(if
				(and
					(not (global2 script?))
					(!= (pEvent type?) evVERB)
					(self onMe: pEvent)
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
					(not (pEvent modifiers?))
					(== (gIconBar curIcon?) (gIconBar at: 0))
				)
				(cond 
					((proc819_5 70) (pEvent claimed: 1) (dockDoor doVerb: 4))
					((proc819_5 113) (pEvent claimed: 1) (ladder doVerb: 4))
					(else (super handleEvent: pEvent &rest))
				)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb)
		(global2 doVerb: &rest)
	)
)

(instance dock of EcoFeature
	(properties
		x 315
		y 119
		nsTop 109
		nsLeft 248
		nsBottom 169
		nsRight 319
		sightAngle 45
		onMeCheck $1000
		approachX 250
		approachY 118
		lookStr 25
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
	
	(method (handleEvent pEvent &tmp temp0)
		(if (User controls?)
			(if
				(and
					(not (global2 script?))
					(!= (pEvent type?) evVERB)
					(self onMe: pEvent)
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
					(not (pEvent modifiers?))
					(== (gIconBar curIcon?) (gIconBar at: 0))
				)
				(if (not (proc819_5 70))
					(if (not (proc819_5 113))
						(pEvent claimed: 1)
						(dockDoor doVerb: 4)
					else
						(pEvent claimed: 1)
						(ladder doVerb: 4)
					)
				else
					(super handleEvent: pEvent &rest)
				)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 27)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance water of EcoFeature
	(properties
		x 298
		y 180
		nsTop 150
		nsLeft 266
		nsBottom 189
		nsRight 319
		sightAngle 45
		onMeCheck $4000
		approachX 313
		approachY 133
		lookStr 30
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(4
				(EcoNarrator posn: 140 20 init: 5 0 0 30)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance safeArea of EcoFeature
	(properties
		x 158
		y 159
		nsTop 120
		nsLeft 62
		nsBottom 189
		nsRight 227
		sightAngle 45
		onMeCheck $0200
		approachX 228
		approachY 109
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dolphin of EcoActor
	(properties
		x 160
		y 100
		view 390
		signal $4000
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(6
				(if (== global247 1)
					(EcoNarrator posn: 140 20 init: 5 0 0 131)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(4
				(cond 
					((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
					((== global247 10) ((ScriptID 59 0) cue:))
					(
						(and
							(<= 11 global247)
							(<= global247 14)
							(proc819_5 113)
						)
						(EcoNarrator posn: 140 20 init: 5 0 0 93)
					)
					((>= global247 15) (EcoNarrator posn: 140 20 init: 5 0 0 46))
					((<= global247 6) (ladder doVerb: 4))
					(else (EcoNarrator posn: 140 20 init: 5 0 0 126))
				)
			)
			(1
				(switch global247
					(1
						(EcoNarrator posn: 140 20 init: 5 0 0 8)
					)
					(2
						(EcoNarrator posn: 140 20 init: 5 0 0 31)
					)
					(3
						(EcoNarrator posn: 140 20 init: 5 0 0 32)
					)
					(4
						(EcoNarrator posn: 140 20 init: 5 0 0 72)
					)
					(5
						(EcoNarrator posn: 140 20 init: 5 0 0 105)
					)
					(6
						(if (= local0 (not local0))
							(EcoNarrator posn: 140 20 init: 5 0 0 38)
						else
							(EcoNarrator posn: 140 20 init: 5 0 0 41)
						)
					)
					(9
						(EcoNarrator posn: 140 20 init: 5 0 0 78)
					)
					(11
						(EcoNarrator posn: 140 20 init: 5 0 0 122)
					)
					(12
						(EcoNarrator posn: 140 20 init: 5 0 0 107)
					)
					(13
						(EcoNarrator posn: 140 20 init: 5 0 0 108)
					)
					(14
						(EcoNarrator posn: 140 20 init: 5 0 0 109)
					)
					(10
						(EcoNarrator posn: 140 20 init: 5 0 0 78)
					)
					(15
						(EcoNarrator posn: 140 20 init: 5 0 0 81)
					)
					(16
						(EcoNarrator posn: 140 20 init: 5 0 0 81)
					)
					(17
						(EcoNarrator posn: 140 20 init: 5 0 0 81)
					)
				)
			)
			(44
				(cond 
					(
					(and (not (proc819_5 113)) (not (proc819_5 70)))
						(switch temp0
							(25
								(if (< global247 15)
									(global2 setScript: throwFish)
								else
									((ScriptID 2 0) init: 1 0 0 24 1)
								)
							)
							(24
								(cond 
									((and (<= 11 global247) (<= global247 16))
										(switch global247
											(11
												(global2 setScript: (ScriptID 61 0))
											)
											(12
												(global2 setScript: (ScriptID 61 0))
											)
											(13
												(global2 setScript: (ScriptID 61 0))
											)
											(14
												(global2 setScript: (ScriptID 61 1))
											)
											(15
												(global2 setScript: (ScriptID 61 0))
											)
											(16
												((ScriptID 2 0) init: 1 0 0 32)
											)
											(else 
												(if (<= 11 global247)
													(EcoNarrator posn: 140 20 init: 5 0 0 75)
												else
													(EcoNarrator posn: 140 20 init: 5 0 0 40)
												)
											)
										)
									)
									((proc819_5 113) (EcoNarrator posn: 140 20 init: 5 0 0 112))
									((== global247 1) (EcoNarrator posn: 140 20 init: 5 0 0 40))
									((== global247 2) (EcoNarrator posn: 140 20 init: 5 0 0 73))
									((< global247 4) (EcoNarrator posn: 140 20 init: 5 0 0 75))
									((< global247 6) (EcoNarrator posn: 140 20 init: 5 0 0 40))
									((== global247 6) (EcoNarrator posn: 140 20 init: 5 0 0 76))
									((== global247 17) ((ScriptID 2 0) init: 1 0 0 36 1 0 380))
									(else (super doVerb: theVerb temp0 &rest))
								)
							)
							(else 
								(super doVerb: theVerb temp0 &rest)
							)
						)
					)
					((proc819_5 113)
						(cond 
							((== global247 10) (EcoNarrator posn: 140 20 init: 5 0 0 92))
							((== temp0 15) (global2 setScript: climbOutToThrowFrisbee))
							(else (EcoNarrator posn: 140 20 init: 5 0 0 61))
						)
					)
					((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 69))
					((proc819_5 111) (EcoNarrator posn: 140 20 init: 5 0 0 117))
				)
			)
			(2
				(cond 
					((proc819_5 70) (EcoNarrator posn: 140 20 init: 5 0 0 128))
					((== global247 1)
						(proc0_4 2 226)
						(= global247 2)
						(= cycleSpeed (= global249 (- global249 2)))
						(if (== gSouth 400)
							((ScriptID 2 1) init: 2 0 0 42 1)
						else
							((ScriptID 2 1) init: 3 0 0 16 1)
						)
					)
					((== global247 2)
						(proc0_4 2 227)
						(if (== gSouth 400)
							((ScriptID 2 1) init: 2 0 0 43 1)
						else
							((ScriptID 2 1) init: 3 0 0 17 1)
						)
						(= global247 3)
						(= cycleSpeed (= global249 (- global249 4)))
					)
					((== global247 3)
						(proc0_4 2 228)
						(= global247 4)
						(= cycleSpeed (= global249 (- global249 6)))
						(global2 setScript: (ScriptID 59 1))
					)
					((< global247 4) (EcoNarrator posn: 140 20 init: 5 0 0 72))
					((< global247 11) (EcoNarrator posn: 140 20 init: 5 0 0 95))
					((== global247 11) ((ScriptID 2 1) init: 2 0 0 52 1))
					((and (<= 12 global247) (<= global247 14)) (EcoNarrator posn: 140 20 init: 5 0 0 119))
					(else ((ScriptID 2 0) init: 4 0 0 25 1))
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (setHeading param1)
		(return
			(if (!= heading param1)
				(super setHeading: param1 &rest)
			else
				(return heading)
			)
		)
	)
)

(instance pool of EcoFeature
	(properties
		x 67
		y 10
		nsTop 83
		nsBottom 189
		nsRight 188
		sightAngle 45
		onMeCheck $0100
		approachX 62
		approachY 66
		lookStr 5
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
	
	(method (handleEvent pEvent &tmp temp0)
		(if (User controls?)
			(if
				(and
					(not (global2 script?))
					(!= (pEvent type?) evVERB)
					(self onMe: pEvent)
					(not (pEvent modifiers?))
					(== (gIconBar curIcon?) (gIconBar at: 0))
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
					(not (proc819_5 113))
					(not (proc819_5 70))
				)
				(pEvent claimed: 1)
				(ladder doVerb: 4)
			else
				(super handleEvent: pEvent &rest)
			)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator posn: 140 20 init: 5 0 0 lookStr)
			)
			(44 (dolphin doVerb: 44 &rest))
			(2 (dolphin doVerb: 2 &rest))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fJump of JumpTo
	(properties)
	
	(method (init)
		(self completed: 0 gx: 0 gy: 1 xStep: 1 yStep: 1)
		(super init: &rest)
	)
)
