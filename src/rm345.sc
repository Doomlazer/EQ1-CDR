;;; Sierra Script 1.0 - (do not remove this comment)
(script# 345)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use ForwardCounter)
(use n958)
(use DPath)
(use Cycle)
(use Obj)

(public
	rm345 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 9] = [146 153 174 177 200 224 225 227 233]
	[local19 9] = [40 29 24 14 20 23 30 25 20]
	[local28 9] = [116 134 155 171 199 224 246 261 268]
	[local37 9] = [21 38 52 61 63 61 55 47 42]
	[local46 9] = [0 1 2 3 4 5 6 7 7]
	[local55 9] = [0 1 1 2 3 4 5 6 7]
	[local64 8] = [255 255 256 267 269 273 293 307]
	[local72 8] = [20 50 65 85 83 74 63 61]
)
(procedure (localproc_1508 param1 &tmp temp0)
	(if (> global102 16)
		(= local0 1)
		(= local1 0)
		(= local2 param1)
	else
		(global2 drawPic: 340 8)
	)
)

(procedure (localproc_152f param1 &tmp temp0)
	(if (> global102 16)
		(= temp0 100)
		(while (>= temp0 0)
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait param1)
			(= temp0 (- temp0 5))
		)
	else
		(global2 drawPic: 901 8)
	)
)

(instance rm345 of EcoRoom
	(properties
		picture 340
		style $8009
		horizon -20
		vanishingY -20
		lookStr 46
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(proc819_6)
		(super init: &rest)
		(if (proc819_5 73)
			(global2 setScript: emptyRoom)
		else
			(global2 setScript: chaseSequence)
		)
	)
	
	(method (doit)
		(if local0
			(Palette
				palSET_INTENSITY
				0
				255
				(= local1 (+ local1 local2))
			)
			(if (>= local1 100) (= local0 0))
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		(gIconBar enable: 7)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (== local7 1)
					(EcoNarrator init: 3 0 0 41)
				else
					(EcoNarrator init: 3 0 0 46)
				)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance manta of EcoActor
	(properties
		x 450
		y -50
		yStep 8
		view 582
		signal $2000
		xStep 11
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 3 0 0 43))
			(2 (EcoNarrator init: 3 0 0 43))
			(4 (EcoNarrator init: 3 0 0 44))
			(44
				(EcoNarrator init: 3 0 0 44)
			)
			(6 (EcoNarrator init: 3 0 0 51))
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance driftNet of EcoActor
	(properties
		x 232
		y 103
		z 50
		yStep 6
		view 363
		xStep 9
		moveSpeed 3
	)
	
	(method (init)
		(self
			setLoop: 0
			setPri: 2
			ignoreActors: 1
			ignoreHorizon: 1
			cycleSpeed: 26
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp theTheVerb)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= theTheVerb theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if local8
					(EcoNarrator init: 3 0 0 25)
				else
					(EcoNarrator init: 3 0 0 24)
				)
				(= local8 (^ local8 $0001))
			)
			(1
				(if (== local3 0)
					(if local9
						(EcoNarrator init: 3 0 0 28)
					else
						(EcoNarrator init: 3 0 0 27)
					)
					(= local9 (^ local9 $0001))
				)
			)
			(44
				(switch theTheVerb
					(17
						(rm345 setScript: adamCutsOutOfNet)
						(= local6 1)
						(gEgo cycleSpeed: 30)
						(proc0_4 10 339)
					)
					(37
						(EcoNarrator init: 3 0 0 26)
					)
					(else 
						(EcoNarrator init: 3 0 0 45)
					)
				)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 11 1)
			)
			(else 
				(super doVerb: theVerb theTheVerb &rest)
			)
		)
	)
)

(instance delInNet of EcoActor
	(properties
		x 246
		view 603
		loop 7
	)
	
	(method (init)
		(self setPri: 9 ignoreActors: 1 cycleSpeed: 26)
		(super init: &rest)
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
)

(instance cable3 of EcoView
	(properties
		x 93
		y 121
		view 580
		loop 4
		cel 2
		priority 15
		signal $5011
	)
)

(instance chaseSequence of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gIconBar disable: 7)
				(proc958_0 128 603 802 831 342)
				(proc819_7)
				(gDelph
					yStep: 6
					xStep: 9
					posn: 400 -20
					z: 0
					setScript: (ScriptID 127 0) 0 920
					ignoreHorizon: 1
					init:
				)
				(manta init:)
				(gEgo
					yStep: 6
					xStep: 9
					init:
					ignoreHorizon: 1
					posn: 370 -58
					ignoreActors:
				)
				(driftNet init: stopUpd: hide:)
				(= cycles 3)
			)
			(1
				(EcoNarrator init: 3 0 0 49)
				(gEgo setMotion: MoveTo -12 240 self)
				(gDelph
					ignoreActors:
					moveSpeed: (gEgo moveSpeed?)
					setMotion: MoveTo -2 250 self
				)
			)
			(2 0)
			(3
				(manta
					setLoop: 0
					moveSpeed: (gEgo moveSpeed?)
					setCycle: Fwd
					setMotion: MoveTo 0 223 self
				)
			)
			(4
				(manta hide:)
				(localproc_152f 5)
				(= cycles 3)
			)
			(5
				(localproc_1508 5)
				(= cycles 2)
			)
			(6
				(gEgo x: 60 y: -30 setMotion: DPath 35 51 133 150 self)
				(gDelph x: 45 y: -60 setMotion: DPath 19 33 180 220)
			)
			(7
				(gEgo setMotion: MoveTo 175 220)
				(manta
					setLoop: 1
					x: -40
					y: -30
					show:
					setMotion: MoveTo 175 250 self
				)
			)
			(8
				(manta hide:)
				(localproc_152f 5)
				(= cycles 3)
			)
			(9
				(localproc_1508 5)
				(= cycles 2)
			)
			(10
				(gEgo x: 135 y: -30 setMotion: DPath 148 46 91 95 -30 92)
				(gDelph
					x: 145
					y: -45
					setMotion: DPath 183 63 128 98 40 98 self
				)
			)
			(11
				(gDelph setMotion: MoveTo -55 96)
				(manta
					setLoop: 0
					x: 140
					y: -30
					show:
					setMotion: MoveTo -40 128 self
				)
				(= cycles 4)
			)
			(12 (EcoNarrator init: 3 0 0 2))
			(13
				(manta hide:)
				(localproc_152f 5)
				(= cycles 3)
			)
			(14
				(global2 setScript: crashIntoNet)
			)
		)
	)
)

(instance crashIntoNet of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1508 5)
				(proc819_3 73)
				(driftNet show:)
				(global2 setRegions: 51)
				(= cycles 2)
			)
			(1
				(gEgo
					setCycle: 0
					posn: 370 79
					setCycle: Walk
					setMotion: MoveTo 300 84 self
				)
				((gDelph script?) register: 918)
				(gDelph
					ignoreActors: 1
					posn: 370 60
					moveSpeed: 3
					looper: 0
					setCycle: 0
					setMotion: MoveTo 300 68
				)
			)
			(2
				(gDelph
					view: 342
					setLoop: 0
					cycleSpeed: (* (gEgo moveSpeed?) 2)
					setCycle: Fwd
					setMotion: MoveTo 229 68
				)
				(gEgo
					cycleSpeed: (* (gEgo moveSpeed?) 2)
					setMotion: MoveTo 241 84 self
				)
			)
			(3
				(gLongSong number: 341 loop: -1 play:)
				(driftNet
					x: 217
					y: 107
					setCel: 1
					setMotion: MoveTo 182 124
				)
				(gEgo
					view: 342
					setLoop: 3
					setCycle: End
					setMotion: MoveTo 208 78
				)
				(gDelph
					setLoop: 1
					setCycle: End
					setMotion: MoveTo 199 76 self
				)
			)
			(4
				(EcoNarrator posn: -1 130 init: 3 0 0 30 self)
			)
			(5
				(driftNet setCel: 2 setMotion: MoveTo 141 123)
				(gEgo
					setLoop: 4
					setCycle: Fwd
					cycleSpeed: 18
					setMotion: MoveTo 167 77
				)
				(gDelph setLoop: 2 setCycle: Fwd setMotion: MoveTo 158 75)
				(= seconds 2)
			)
			(6
				(EcoNarrator posn: -1 130 init: 3 0 0 31 self)
			)
			(7
				(gEgo setScript: trappedTalk self)
			)
			(8
				(EcoNarrator posn: -1 130 init: 3 0 0 32 self)
			)
			(9
				(gLongSong number: 340 loop: -1 play:)
				(manta posn: 380 50 show: setMotion: MoveTo 30 280 self)
			)
			(10
				(driftNet setScript: timedHintTalk)
				(manta setScript: mantaCircles)
				(gDelph setScript: shiftNetAround)
				(= cycles 1)
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

(instance mantaCircles of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(manta
					view: 603
					x: 400
					y: 7
					xStep: 4
					yStep: 4
					setLoop: 0
					signal: 24576
					setPri: 1
					cycleSpeed: 26
					hide:
				)
				(= seconds 2)
			)
			(1
				(manta
					x: -60
					y: 50
					show:
					xStep: 34
					yStep: 2
					setCycle: 0
					setLoop: 1
					setCel: 4
					moveSpeed: 18
					setMotion: MoveTo 330 100 self
				)
			)
			(2
				(if (== local6 1) (self dispose:) else (= seconds 2))
			)
			(3
				(manta
					setLoop: 2
					setCel: 0
					posn: 283 36
					setCycle: CT 4 1 self
				)
			)
			(4
				(manta
					xStep: 38
					yStep: 3
					setCycle: 0
					setCel: 4
					moveSpeed: 18
					setMotion: MoveTo 60 56 self
				)
			)
			(5
				(if (== local5 0)
					(EcoNarrator posn: -1 130 init: 3 0 0 33 self)
					(= local5 1)
				else
					(self cue:)
				)
			)
			(6 (= seconds 1))
			(7
				(if (== local6 1)
					(self dispose:)
				else
					(= state -1)
					(self cue:)
				)
			)
		)
	)
)

(instance adamCutsOutOfNet of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 167 y: 77)
				(driftNet x: 141 y: 123)
				(gDelph x: 158 y: 75 setScript: 0)
				(proc0_1)
				(EcoNarrator posn: -1 130 init: 3 0 0 42 self)
			)
			(1
				(gEgo
					view: 342
					loop: 5
					cel: 0
					posn: 165 76
					setPri: 14
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(EcoNarrator posn: -1 130 init: 3 0 0 36 self)
			)
			(3
				(if (manta script?)
					(if (driftNet script?)
						(timedHintTalk dispose:)
						(= state 2)
						(= cycles 1)
					else
						(= state 2)
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(4
				(if (driftNet script?) (timedHintTalk dispose:))
				((ScriptID 2 0) init: 2 0 0 41 1 self)
				(driftNet
					setStep: 1 2
					cycleSpeed: 12
					setMotion: PolyPath 144 (- (driftNet y?) 70)
				)
				(gDelph
					setStep: 1 2
					cycleSpeed: 12
					setScript: 0
					setMotion: PolyPath 161 (- (gDelph y?) 70)
				)
			)
			(5
				((ScriptID 2 1) init: 1 0 0 12 1 self)
			)
			(6
				(proc819_6)
				(gEgo
					x: 132
					y: 89
					view: 802
					loop: 3
					setPri: 14
					cel: 0
					setMotion: MoveTo 185 56
				)
				(EcoNarrator posn: -1 130 init: 3 0 0 37 self)
			)
			(7
				(driftNet setScript: 0)
				(manta setScript: mantaCarriesOffDel)
				(self dispose:)
			)
		)
	)
)

(instance mantaCarriesOffDel of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(manta
					view: 585
					setLoop: 0
					cel: 0
					x: -32
					y: -264
					xStep: 20
					yStep: 15
					setPri: 13
					cycleSpeed: 12
					setMotion: MoveTo 108 16 self
				)
			)
			(1
				(EcoNarrator posn: -1 130 init: 3 0 0 38 self)
			)
			(2
				(manta setCycle: CT 3 1 self)
				(driftNet
					setCycle: 0
					setLoop: 0
					setCel: 2
					xStep: 6
					yStep: 4
					setPri: 10
					moveSpeed: 12
					setMotion: MoveTo 201 -36
				)
				(gDelph hide:)
				(gEgo setCycle: 0 setLoop: (gEgo loop?))
			)
			(3
				(EcoNarrator posn: -1 130 init: 3 0 0 47 self)
			)
			(4
				(gLongSong number: 342 loop: -1 play:)
				(manta setCycle: End self)
				(gEgo
					view: 221
					setLoop: 0
					cel: 2
					cycleSpeed: 3
					setCycle: reverseCounter 6
					setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 120)
				)
			)
			(5
				(proc819_6)
				(gEgo loop: 0 x: (- (gEgo x?) 2) y: (- (gEgo y?) 8))
				(manta
					cycleSpeed: 12
					setCycle: End
					setMotion: MoveTo 380 0 self
				)
			)
			(6
				(proc819_6)
				((ScriptID 2 0) init: 2 0 0 40 1 self)
				(delInNet init: posn: -30 0 view: 603 loop: 7 cel: 0)
			)
			(7
				(driftNet hide:)
				(manta view: 603 loop: 3 cel: 0 x: 273 y: 39 setCycle: 0)
				(delInNet posn: 254 16 setPri: 10)
				(Animate (gCast elements?) 1)
				(= temp0 1)
				(while (< temp0 8)
					(Wait 0)
					(delInNet
						x: [local64 temp0]
						y: [local72 (manta cel: temp0)]
						cel: (Wait 10)
					)
					(Animate (gCast elements?) 1)
					(++ temp0)
				)
				(manta hide:)
				(delInNet hide:)
				(= cycles 1)
			)
			(8
				(localproc_152f 5)
				(manta setPri: 1 setCycle: 0 setLoop: 0)
				(gDelph setPri: 2 setCycle: 0 setLoop: 0)
				(gEgo hide:)
				(= cycles 3)
			)
			(9
				(if (> global102 16)
					(localproc_1508 5)
					(global2 drawPic: 580)
				else
					(global2 drawPic: 580 8)
				)
				(cabinDoor init:)
				(cable1 init:)
				(cable2 init:)
				(cable3 init:)
				(= cycles 40)
			)
			(10
				(manta view: 603 setLoop: 3 cel: 0 x: 146 y: 40 show:)
				(gDelph view: 603 setLoop: 7 cel: 0 x: 116 y: 21 show:)
				(Animate (gCast elements?) 1)
				(= temp0 1)
				(while (< temp0 9)
					(gDelph
						x: [local28 temp0]
						y:
							[local37 (manta
								x: [local10 temp0]
								y: [local19 (Wait 10)]
								cel: [local46 (Wait 0)]
							)]
						cel: [local55 temp0]
					)
					(Animate (gCast elements?) 1)
					(++ temp0)
				)
				(= cycles 1)
			)
			(11
				(cabinDoor dispose:)
				(cable1 dispose:)
				(cable2 dispose:)
				(cable3 dispose:)
				(gDelph hide:)
				(manta hide:)
				(localproc_152f 5)
				(= cycles 3)
			)
			(12
				(if (> global102 16)
					(gEgo show:)
					(global2 drawPic: 340)
				)
				(localproc_1508 5)
				(= cycles 35)
			)
			(13
				(gLongSong number: 343 loop: 1 play:)
				(proc819_6)
				(gEgo
					yStep: 2
					cycleSpeed: 6
					setMotion: MoveTo (gEgo x?) 220 self
				)
			)
			(14
				(EcoNarrator posn: -1 130 init: 3 0 0 39 self)
			)
			(15
				(= local7 1)
				(EcoNarrator posn: -1 130 init: 3 0 0 40 self)
			)
			(16 (global2 newRoom: 480))
		)
	)
)

(instance shiftNetAround of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(self setScript: (ScriptID 127 0) 0 920)
	)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0 (= cycles (Random 1 2)))
			(1
				(switch (Random 0 4)
					(0 (= temp0 0) (= temp1 1))
					(1 (= temp0 1) (= temp1 0))
					(2 (= temp0 0) (= temp1 -1))
					(3 (= temp0 -1) (= temp1 0))
					(4 (= temp0 0) (= temp1 0))
				)
				(gEgo x: (+ 167 temp0) y: (+ 77 temp1))
				(driftNet x: (+ 141 temp0) y: (+ 123 temp1))
				(gDelph x: (+ 158 temp0) y: (+ 75 temp1))
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance emptyRoom of HandsOffScript
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo y: 220 init: setMotion: MoveTo 160 150 self)
			)
			(1
				(EcoNarrator init: 3 0 0 41 self)
			)
			(2
				(gEgo setMotion: MoveTo 160 220 self)
			)
			(3 (global2 newRoom: 480))
		)
	)
)

(instance timedHintTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 30))
			(1
				((ScriptID 2 0) init: 2 0 0 12 1 self)
			)
			(2 (= seconds 40))
			(3
				((ScriptID 2 0) init: 2 0 0 36 1 self)
			)
			(4 (= seconds 40))
			(5
				((ScriptID 2 0) init: 2 0 0 37 1 self)
			)
			(6 (= seconds 40))
			(7
				((ScriptID 2 0) init: 2 0 0 38 1 self)
			)
			(8 (= seconds 40))
			(9
				((ScriptID 2 0) init: 2 0 0 38 1 self)
			)
			(10 (= seconds 40))
			(11
				((ScriptID 2 0) init: 2 0 0 38 1 self)
			)
			(12 (= seconds 40))
			(13 (self dispose:))
		)
	)
)

(instance trappedTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local4 1) (= state 5))
				(self cue:)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 10 1 self)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 9 1 self)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 11 1 self)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 10 1 self)
				(= local4 1)
			)
			(5 (= state 6) (self cue:))
			(6
				((ScriptID 2 0) init: 2 0 0 11 1 self)
			)
			(7 (self dispose:))
		)
	)
)

(instance reverseCounter of ForwardCounter
	(properties
		cycleDir -1
	)
	
	(method (doit &tmp forwardCounterNextCel)
		(if
		(< (= forwardCounterNextCel (self nextCel:)) 0)
			(self cycleDone:)
		else
			(client cel: forwardCounterNextCel)
		)
	)
	
	(method (cycleDone)
		(if (-- count)
			(client cel: (client lastCel:))
			(client cycleSpeed: (+ (client cycleSpeed?) 1))
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)
