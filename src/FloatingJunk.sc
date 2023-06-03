;;; Sierra Script 1.0 - (do not remove this comment)
(script# 322)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Cycle)
(use User)
(use Obj)

(public
	rm322 0
)

(local
	local0
	gEgoIllegalBits
	local2
	local3
	local4
)
(instance rm322 of EcoRoom
	(properties
		picture 320
		style $8009
		horizon 90
		south 321
	)
	
	(method (init)
		(= global250 1)
		(= global251 1)
		(= local4 (not (proc819_5 62)))
		(proc819_6)
		(gEgo
			x: 150
			init:
			illegalBits: -32768
			ignoreHorizon: 1
			ignoreActors: 0
		)
		((gEgo cycler?) caller: sepEgoDel)
		(super init: &rest)
		(shipATP addToPic:)
		(junkPlume addToPic:)
		(j1 init:)
		(j2 init:)
		(j3 init:)
		(j4 init:)
		(j5 init:)
		(j6 init:)
		(j7 init:)
		(j9 init:)
		(j10 init:)
		(j11 init:)
		(j12 init:)
		(j13 init:)
		(j14 init:)
		(j16 init:)
		(spew setCycle: Fwd init:)
		(gLongSong2 number: 321 loop: -1 flags: 1 play:)
		(shipFlags1 setCycle: Fwd init:)
		(shipFlags2 setCycle: Fwd init:)
		(shipFlags3 setCycle: Fwd init:)
		(if (not (proc819_5 248)) (jar init: stopUpd:))
		(j17 init:)
		(j18 init:)
		(j19 init:)
		(j20 init:)
		(j21 init:)
		(j22 init:)
		(j23 init:)
		(j24 init:)
		(j25 init:)
		(j26 init:)
		(j27 init:)
		(j28 init:)
		(j29 init:)
		(j30 init:)
		(sky init:)
		(water init:)
		(boy init: cel: (if (proc819_5 62) 7 else 0))
	)
	
	(method (doit)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 4) (self setScript: toWest))
			((& (gEgo onControl: 1) $0004) (self setScript: pushEgoBack))
			((< (gEgo y?) 122)
				(if (< (gEgo x?) 165)
					(EcoNarrator init: 1 0 0 14)
				else
					(EcoNarrator init: 1 0 0 16)
				)
				(gEgo setMotion: 0 posn: (gEgo x?) 124)
			)
		)
		(if (and local4 (User canControl:)) (proc0_1))
		(super doit: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong2 stop:)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (notify)
		(if argc (proc0_4 10 249) (self setScript: goDiving))
	)
)

(instance sepEgoDel of Script
	(properties)
	
	(method (cue param1)
		(if param1
			(gDelph dispose:)
		else
			(gDelph
				view: 826
				init:
				setCycle: Fwd
				x:
					(switch (gEgo loop?)
						(3 (- (gEgo x?) 2))
						(2 (gEgo x?))
						(0 (+ (gEgo x?) 18))
						(1 (- (gEgo x?) 18))
						(7 (- (gEgo x?) 10))
						(6 (+ (gEgo x?) 10))
						(5 (- (gEgo x?) 16))
						(4 (+ (gEgo x?) 16))
					)
				y:
					(switch (gEgo loop?)
						(3 (- (gEgo y?) 12))
						(2 (+ (gEgo y?) 12))
						(7 (- (gEgo y?) 7))
						(5 (+ (gEgo y?) 8))
						(6 (- (gEgo y?) 7))
						(4 (+ (gEgo y?) 8))
						(else  (- (gEgo y?) 2))
					)
				loop: (gEgo loop?)
			)
			(if (not (proc819_5 62))
				(boy setScript: boyLosesBalloons)
			)
		)
	)
)

(instance goDiving of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					put: 19
					setCycle: 0
					view: 810
					setLoop: 0
					cel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(EcoNarrator init: 1 0 0 21)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gLongSong stop:)
				(global2 newRoom: 340)
			)
		)
	)
)

(instance toWest of Script
	(properties)
	
	(method (doit)
		(if (User canControl:)
			(switch (gEgo edgeHit?)
				(1
					(EcoNarrator init: 1 0 0 18)
					(gEgo setMotion: 0 y: 94)
				)
				(2
					(EcoNarrator init: 1 0 0 14)
					(gEgo setMotion: 0 x: 313)
				)
				(4 (gEgo setMotion: 0 x: 7))
				(3
					((ScriptID 2 0) init: 3 0 0 2 1)
					(gEgo setMotion: 0 posn: (gEgo x?) 187 setHeading: 360)
				)
			)
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: MoveTo -38 (gEgo y?) self)
				(if (gCast contains: gDelph)
					(gDelph setMotion: MoveTo -38 (gEgo y?) talkScript: 0)
				)
				(gLongSong2 stop:)
			)
			(1
				(shipFlags1 startUpd: dispose:)
				(shipFlags2 startUpd: dispose:)
				(shipFlags3 startUpd: dispose:)
				(balloons startUpd: dispose:)
				(boy startUpd: dispose:)
				(jar startUpd: dispose:)
				(shipATP dispose:)
				(junkPlume dispose:)
				(j1 dispose:)
				(j2 dispose:)
				(j3 dispose:)
				(j4 dispose:)
				(j5 dispose:)
				(j6 dispose:)
				(j7 dispose:)
				(j9 dispose:)
				(j10 dispose:)
				(j11 dispose:)
				(j12 dispose:)
				(j13 dispose:)
				(j14 dispose:)
				(j16 dispose:)
				(j17 dispose:)
				(j18 dispose:)
				(j19 dispose:)
				(j20 dispose:)
				(j21 dispose:)
				(j22 dispose:)
				(j23 dispose:)
				(j24 dispose:)
				(j25 dispose:)
				(j26 dispose:)
				(j27 dispose:)
				(j28 dispose:)
				(j29 dispose:)
				(j30 dispose:)
				(spew dispose:)
				(gDelph dispose:)
				(= cycles 1)
			)
			(2
				(global2 drawPic: 320 -32759)
				(island init:)
				(proc819_6)
				(gEgo
					x: 280
					edgeHit: 0
					illegalBits: -32768
					setMotion: MoveTo 160 130 self
				)
			)
			(3
				((gEgo cycler?) caller: sepEgoDel)
				(= cycles 200)
			)
			(4
				(gEgo setCycle: 0 view: 818 cycleSpeed: 17 setCycle: Fwd)
				(gFeatures addToFront: dive)
				(dive init:)
				(proc0_2)
				(= local2 1)
				(proc819_3 68)
				(= cycles 60)
			)
			(5
				((ScriptID 2 0) init: 3 0 0 3 1 self)
			)
			(6
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(7
				((ScriptID 2 0) init: 3 0 0 4 1 self)
			)
			(8 (= seconds 5))
			(9
				(if (gEgo script?)
					(-- state)
					(= seconds 4)
				else
					((ScriptID 2 0) init: 3 0 0 1 1 self)
				)
			)
			(10 (= seconds 5))
			(11
				(if (gEgo script?)
					(-- state)
					(= seconds 4)
				else
					((ScriptID 2 0) init: 3 0 0 2 1 self)
				)
			)
			(12 (= seconds 6))
			(13
				(proc819_4 68)
				(gEgo setScript: 0)
				(client setScript: goDiving)
			)
		)
	)
)

(instance pushEgoBack of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					y: (- (gEgo y?) 7)
					setLoop: (gEgo loop?)
					setMotion: MoveTo (- (gEgo x?) 30) (gEgo y?) self
				)
			)
			(1
				(gEgo setLoop: -1 setMotion: 0)
				(= ticks 10)
			)
			(2
				(EcoNarrator init: 1 0 0 16)
				(self dispose:)
			)
		)
	)
)

(instance boyLosesBalloons of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 20))
			(1
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(2
				((ScriptID 2 0) init: 3 0 0 6 1 self)
			)
			(3 (= seconds 3))
			(4
				((ScriptID 2 1) init: 2 0 0 5 1 self)
			)
			(5 (= seconds 2))
			(6
				((ScriptID 2 1) init: 2 0 0 6 1 self)
			)
			(7
				(boy cel: 0 setCycle: CT (Random 1 3) 1 self)
			)
			(8
				(if (< (++ local0) 4)
					(= state (- state 2))
					(boy setCycle: CT 0 -1 self)
				else
					(boy setCycle: CT 4 1 self)
				)
			)
			(9
				(boy setCycle: End)
				(balloons init: setMotion: MoveTo 216 11 self)
			)
			(10
				((ScriptID 2 0) init: 3 0 0 7 1 self)
			)
			(11
				(balloons setStep: 5 5 setMotion: MoveTo 230 -6 self)
			)
			(12
				(boy stopUpd:)
				(balloons dispose:)
				(if (not (proc819_5 15))
					(gDelph talkScript: trashbagTalk)
				)
				(proc819_3 62)
				(= local4 0)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance trashbagTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 3 1 self)
			)
			(1
				((ScriptID 2 0) init: 3 0 0 5 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance nobagTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 1 0 0 15 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance island of EcoView
	(properties
		x 148
		y 58
		view 322
		signal $0001
		lookStr 22
	)
	
	(method (init)
		(super init: &rest)
		(water lookStr: 20)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 19))
			(3 (EcoNarrator init: 1 0 0 18))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance shipATP of EcoView
	(properties
		x 167
		y 88
		view 327
		signal $0001
		lookStr 8
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 26))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance spew of EcoProp
	(properties
		x 192
		y 96
		z 20
		view 327
		loop 1
		priority 6
		signal $0010
		cycleSpeed 8
		lookStr 7
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 25))
			(4 (EcoNarrator init: 1 0 0 30))
			(44
				(if (== theVerb 22)
					(EcoNarrator init: 1 0 0 38)
				else
					(EcoNarrator init: 1 0 0 30)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance junkPlume of EcoView
	(properties
		x 192
		y 76
		view 327
		loop 2
		priority 8
		signal $1011
		lookStr 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 6))
			(4 (EcoNarrator init: 1 0 0 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shipFlags1 of EcoProp
	(properties
		x 139
		y 7
		view 327
		loop 3
		signal $7000
	)
)

(instance shipFlags2 of EcoProp
	(properties
		x 138
		y 8
		view 327
		loop 9
		cel 3
		signal $7000
	)
)

(instance shipFlags3 of EcoProp
	(properties
		x 255
		y 7
		view 327
		loop 10
		signal $7000
	)
)

(instance boy of EcoProp
	(properties
		x 187
		y 40
		view 327
		loop 6
		signal $6000
		cycleSpeed 20
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (>= cel 5)
					(EcoNarrator init: 1 0 0 31)
				else
					(EcoNarrator init: 1 0 0 35)
				)
			)
			(4 (EcoNarrator init: 1 0 0 32))
			(2 (EcoNarrator init: 1 0 0 33))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance jar of EcoView
	(properties
		x 35
		y 167
		view 327
		loop 7
		lookStr 5
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (proc999_5 theVerb 4 6)
			(global2 setScript: getJunk self theVerb)
		else
			(super doVerb: theVerb temp0 &rest)
		)
	)
)

(instance balloons of EcoActor
	(properties
		x 198
		y 37
		view 327
		loop 8
		signal $6800
		illegalBits $0000
		xStep 2
		moveSpeed 12
	)
)

(instance j1 of EcoView
	(properties
		x 52
		y 120
		view 327
		loop 4
		signal $0001
		lookStr 13
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 30))
			(4
				(if (proc819_5 15)
					(EcoNarrator init: 1 0 0 30)
				else
					(EcoNarrator init: 6)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance j2 of EcoView
	(properties
		x 160
		y 100
		view 327
		loop 4
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j3 of EcoView
	(properties
		x 61
		y 116
		view 327
		loop 4
		cel 1
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j4 of EcoView
	(properties
		x 4
		y 121
		view 327
		loop 4
		cel 2
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j5 of EcoView
	(properties
		x 62
		y 112
		view 327
		loop 5
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j6 of EcoView
	(properties
		x 14
		y 109
		view 327
		loop 5
		cel 1
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j7 of EcoView
	(properties
		x 78
		y 115
		view 327
		loop 5
		cel 2
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j9 of EcoView
	(properties
		x 52
		y 112
		view 327
		loop 5
		cel 4
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j10 of EcoView
	(properties
		x 11
		y 115
		view 327
		loop 5
		cel 5
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j11 of EcoView
	(properties
		x 44
		y 110
		view 327
		loop 5
		cel 6
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j12 of EcoView
	(properties
		x 19
		y 113
		view 327
		loop 5
		cel 7
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j13 of EcoView
	(properties
		x 46
		y 104
		view 327
		loop 5
		cel 8
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j14 of EcoView
	(properties
		x 38
		y 114
		view 327
		loop 5
		cel 9
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j16 of EcoView
	(properties
		x 83
		y 118
		view 327
		loop 5
		cel 11
		signal $4001
	)
	
	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(class FloatingJunk of EcoView
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0101
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		lookStr 13
		blockedBy 0
		controlBlock 0
	)
	
	(method (init)
		(if (not (& global116 controlBlock))
			(super init: &rest)
			(gEgo observeControl: controlBlock)
			(self stopUpd:)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(6
				(if (& blockedBy (gEgo illegalBits?))
					(EcoNarrator init: 1 0 0 27)
				else
					(= global116 (| global116 controlBlock))
					(global2 setScript: getJunk self)
				)
			)
			(4
				(if (proc819_5 15)
					(EcoNarrator init: 1 0 0 15)
				else
					(global2 setScript: nobagTalk)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance getJunk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(= gEgoIllegalBits (gEgo illegalBits?))
				(gEgo illegalBits: 0 ignoreActors: 1)
				(if (< (gEgo x?) 110)
					(gEgo setCycle: 0 view: 818 setCycle: Fwd)
				)
				(= cycles 4)
			)
			(1
				(if (< (gEgo x?) 110)
					(gEgo
						setMotion: MoveTo (+ (caller x?) 18) (caller y?) self
					)
				else
					(gEgo setMotion: MoveTo 100 (caller y?) self)
				)
			)
			(2 (= cycles 40))
			(3
				(gEgo
					setCycle: 0
					view: 818
					setCycle: Fwd
					setMotion: MoveTo (+ (caller x?) 8) (caller y?) self
				)
			)
			(4
				(if (== caller jar) (gEgo get: 32) (proc0_4 2 248))
				(caller dispose:)
				(= cycles 30)
			)
			(5
				(gEgo ignoreActors: 0 illegalBits: gEgoIllegalBits)
				(cond 
					((!= caller jar)
						(proc0_4 5 247)
						(gEgo ignoreControl: (caller controlBlock?))
						(cond 
							((not (proc819_5 123)) (proc819_3 123) (EcoNarrator init: 1 0 0 12 self))
							(
							(and (caller blockedBy?) (not (proc819_5 137))) (proc819_3 137) (EcoNarrator init: 1 0 0 29 self))
							(else (= ticks 1))
						)
					)
					((== register 6) (EcoNarrator store: 11 init: 1 0 0 4 self))
					(else (EcoNarrator init: 1 0 0 11 self))
				)
			)
			(6
				(proc0_2)
				(self caller: 0)
				(self dispose:)
			)
		)
	)
)

(instance j17 of FloatingJunk
	(properties
		x 35
		y 126
		view 327
		loop 5
		cel 10
		signal $4000
		controlBlock 8192
	)
)

(instance j18 of FloatingJunk
	(properties
		x 20
		y 125
		view 327
		loop 5
		cel 3
		signal $4000
		blockedBy 8192
		controlBlock 16384
	)
)

(instance j19 of FloatingJunk
	(properties
		x 10
		y 136
		view 327
		loop 4
		cel 2
		signal $4000
		blockedBy 2048
		controlBlock 4096
	)
)

(instance j20 of FloatingJunk
	(properties
		x 9
		y 142
		view 327
		loop 5
		cel 10
		signal $4000
		blockedBy 512
		controlBlock 1024
	)
)

(instance j21 of FloatingJunk
	(properties
		x 9
		y 151
		view 327
		loop 4
		signal $4000
		blockedBy -32768
		controlBlock 256
	)
)

(instance j22 of FloatingJunk
	(properties
		x 22
		y 135
		view 327
		loop 5
		cel 5
		signal $4000
		controlBlock 2048
	)
)

(instance j23 of FloatingJunk
	(properties
		x 3
		y 167
		view 327
		loop 5
		cel 13
		signal $4000
		blockedBy 2
		controlBlock 64
	)
)

(instance j24 of FloatingJunk
	(properties
		x 9
		y 173
		view 327
		loop 5
		cel 7
		signal $4000
		blockedBy 2
		controlBlock 32
	)
)

(instance j25 of FloatingJunk
	(properties
		x 22
		y 174
		view 327
		loop 5
		signal $4000
		controlBlock 2
	)
)

(instance j26 of FloatingJunk
	(properties
		x 28
		y 185
		view 327
		loop 5
		cel 1
		signal $4000
		controlBlock 8
	)
)

(instance j27 of FloatingJunk
	(properties
		x 9
		y 185
		view 327
		loop 5
		cel 4
		signal $4000
		blockedBy 8
		controlBlock 16
	)
)

(instance j28 of FloatingJunk
	(properties
		x 8
		y 160
		view 327
		loop 5
		cel 8
		signal $4000
		blockedBy -32768
		controlBlock 128
	)
)

(instance j29 of FloatingJunk
	(properties
		x 25
		y 144
		view 327
		loop 5
		cel 12
		signal $4000
		controlBlock 512
	)
)

(instance j30 of FloatingJunk
	(properties
		x 27
		y 156
		view 327
		loop 5
		cel 15
		signal $4000
		controlBlock -32768
	)
)

(instance sky of EcoFeature
	(properties
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc819_5 68)
					(EcoNarrator init: 1 0 0 2 0 320)
				else
					(EcoNarrator init: 1 0 0 9)
				)
			)
			(4 (EcoNarrator init: 1 0 0 37))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (< (param1 y?) 56))
	)
)

(instance water of EcoFeature
	(properties
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (EcoNarrator init: 1 0 0 34))
			(4 (EcoNarrator init: 1 0 0 36))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe)
		(return 1)
	)
)

(instance dive of EcoFeature
	(properties
		nsTop 114
		nsLeft 100
		nsBottom 162
		nsRight 227
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gEgo setScript: diveWithoutTanksOn)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance diveWithoutTanksOn of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: 0
					view: 821
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1 (gEgo hide:) (= seconds 2))
			(2
				(gEgo
					show:
					view: 821
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(3 (= cycles 14))
			(4
				(if local3
					(EcoNarrator init: 1 0 0 24 self)
				else
					(= local3 1)
					(EcoNarrator init: 1 0 0 23 self)
				)
			)
			(5
				(gEgo view: 818)
				(proc819_6)
				(self dispose:)
			)
		)
	)
)
