;;; Sierra Script 1.0 - (do not remove this comment)
(script# 640)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Osc)
(use MoveFwd)
(use n958)
(use Cycle)
(use User)
(use Obj)

(public
	rm640 0
)

(local
	local0
)
(instance rm640 of EcoRoom
	(properties
		picture 640
		style $000a
		horizon 15
		south 344
		lookStr 5
	)
	
	(method (init)
		(proc958_0 128 641 642)
		(= global250 2)
		(proc819_6)
		(gEgo init: ignoreActors: ignoreHorizon:)
		(fin init:)
		(lfin init:)
		(whaleMouth init:)
		(whale init:)
		(topOfWhale init:)
		(if (not (proc819_5 96)) (cable init:))
		(if (proc819_5 85) (eye init:))
		(if (proc819_5 90)
			(self setScript: bounceBack)
		else
			(self setScript: comeFromWhale)
		)
		(self setRegions: 51)
		(super init: &rest)
		(gLongSong2 stop:)
		(if
			(or
				(not (proc999_5 (gLongSong number?) 640 644))
				(== (gLongSong prevSignal?) -1)
			)
			(gLongSong number: 640 loop: -1 play:)
		)
		(Animate (gCast elements?) 0)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 1) (self setScript: NoExit))
			((proc999_5 (gEgo edgeHit?) 4 2) (self setScript: stayAndHelp))
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (< ((User curEvent?) y?) 70)
					(EcoNarrator init: 2 0 0 5)
				else
					(EcoNarrator init: 2 0 0 8)
				)
			)
			(2 (EcoNarrator init: 2 0 0 21))
			(6 (EcoNarrator init: 2 0 0 20))
			(4 (EcoNarrator init: 2 0 0 18))
			(44
				(EcoNarrator init: 2 0 0 18)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if
			(and
				(proc819_5 85)
				(not (proc819_5 87))
				(not (proc819_5 140))
				(== newRoomNumber 660)
			)
			(if local0
				(proc819_3 83)
			else
				(whaleMouth setCycle: 0 cel: 5)
				(Animate (gCast elements?) 0)
				(proc819_3 130)
				(proc819_3 90)
			)
		)
		(if (== newRoomNumber south)
			(if (not (proc819_5 85)) (proc819_3 140))
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance bounceBack of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo
					setCycle: 0
					posn: 221 88
					view: 644
					setLoop: 0
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 197 114 self
				)
			)
			(1 (gEgo setCycle: CT 2 1 self))
			(2
				(proc819_4 90)
				(proc819_6 3)
				(gEgo posn: 200 117 ignoreHorizon:)
				(= cycles (= cycles 3))
			)
			(3
				(cond 
					((not (proc819_3 128)) ((ScriptID 2 1) init: 1 0 0 10 1 self))
					((proc819_5 130) (EcoNarrator init: 2 0 0 11 self) (proc819_4 130))
					(else (= cycles (= cycles 2)))
				)
			)
			(4 (proc0_2) (self dispose:))
		)
	)
)

(instance comeFromWhale of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo
					setCycle: 0
					view: 641
					setLoop: 5
					cel: 0
					posn: 230 82
					setMotion: MoveTo 201 111 self
				)
			)
			(1 (gEgo setCycle: End self))
			(2
				(proc819_6 2)
				(gEgo posn: 200 117 setHeading: 0 self ignoreHorizon:)
			)
			(3 (= cycles (= cycles 2)))
			(4
				(cond 
					((proc819_5 140) (proc819_4 140) (= cycles (= cycles 1)))
					((not (proc819_3 129)) (EcoNarrator init: 2 0 0 10 self))
					((proc819_5 131) (proc819_4 131) (EcoNarrator init: 2 0 0 24 self))
					(else (= cycles (= cycles 1)))
				)
			)
			(5 (proc0_2) (self dispose:))
		)
	)
)

(instance mouthScript of Script
	(properties)
	
	(method (init)
		(= start (= start 3))
		(super init: &rest)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(whaleMouth setCycle: CT 2 1 self)
			)
			(1
				(= local0 0)
				(whaleMouth setCycle: End self)
			)
			(2
				(= cycles (= cycles (whaleMouth cycleSpeed?)))
			)
			(3
				(= local0 1)
				(whaleMouth setCycle: Beg self)
			)
			(4
				(= state (= state -1))
				(= cycles (= cycles (whaleMouth cycleSpeed?)))
			)
		)
	)
)

(instance goToWhaleScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(= start (= start 0))
				(gEgo setCycle: Walk setMotion: MoveTo 200 117 self)
			)
			(1
				(gEgo
					view: 641
					setLoop: 0
					cel: 0
					cycleSpeed: 7
					posn: 210 99
					setCycle: End self
				)
			)
			(2
				(if (proc819_5 85)
					(= cycles (= cycles 1))
				else
					(gEgo hide:)
					(= cycles (= cycles 5))
				)
			)
			(3 (global2 newRoom: 660))
		)
	)
)

(instance NoExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(EcoNarrator init: 2 0 0 22 self)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x?) (+ (global2 horizon?) 5) self
				)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance stayAndHelp of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo setMotion: 0)
				(EcoNarrator init: 2 0 0 23 self)
			)
			(1
				(proc819_9 gEgo 160 (gEgo y?) self)
			)
			(2
				(gEgo setMotion: MoveFwd 20 self)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance eye of EcoView
	(properties
		x 221
		y 70
		onMeCheck $0000
		view 642
		loop 2
		signal $4011
	)
)

(instance fin of EcoProp
	(properties
		x 155
		y 68
		view 642
		loop 1
		signal $4010
		cycleSpeed 20
		detailLevel 1
	)
	
	(method (init)
		(self setCycle: Osc)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(whale doVerb: theVerb &rest)
	)
)

(instance lfin of EcoProp
	(properties
		x 204
		y 94
		view 642
		loop 5
		signal $4010
		cycleSpeed 20
		detailLevel 1
	)
	
	(method (init)
		(self setCycle: Osc)
		(super init: &rest)
	)
	
	(method (doVerb theVerb)
		(whale doVerb: theVerb &rest)
	)
)

(instance whaleMouth of EcoProp
	(properties
		x 216
		y 77
		view 642
		cel 5
		signal $4010
		cycleSpeed 25
	)
	
	(method (init)
		(super init: &rest)
		(if (and (proc819_5 85) (not (proc819_5 86)))
			(self setScript: mouthScript)
		else
			(self stopUpd:)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond 
					((proc819_5 86) (EcoNarrator init: 2 0 0 25))
					((proc819_5 85) (EcoNarrator init: 2 0 0 7))
					(else (EcoNarrator init: 2 0 0 14))
				)
			)
			(4
				(if (and (proc819_5 85) (not (proc819_5 86)))
					(goToWhaleScript start: -1)
					(global2 setScript: goToWhaleScript)
					(EcoNarrator init: 2 0 0 12 goToWhaleScript)
				else
					(whale doVerb: theVerb &rest)
				)
			)
			(else 
				(whale doVerb: theVerb &rest)
			)
		)
	)
)

(instance whale of EcoFeature
	(properties
		onMeCheck $0002
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 85)
					(EcoNarrator init: 2 0 0 6)
				else
					(EcoNarrator init: 2 0 0 3)
				)
			)
			(4
				(goToWhaleScript start: -1)
				(global2 setScript: goToWhaleScript)
				(if (not (proc819_5 85))
					(EcoNarrator init: 2 0 0 9 goToWhaleScript)
				else
					(proc819_3 140)
					(EcoNarrator init: 2 0 0 13 goToWhaleScript)
				)
			)
			(2
				(cond 
					((not (proc819_5 85))
						(goToWhaleScript start: -1)
						(global2 setScript: goToWhaleScript)
						(EcoNarrator init: 2 0 0 9 goToWhaleScript)
					)
					((and (proc819_5 85) (not (proc819_5 86)))
						(goToWhaleScript start: -1)
						(global2 setScript: goToWhaleScript)
						(EcoNarrator init: 2 0 0 12 goToWhaleScript)
					)
					(else (EcoNarrator init: 2 0 0 15))
				)
			)
			(44
				(switch temp0
					(12
						(EcoNarrator init: 2 0 0 16)
					)
					(else 
						(EcoNarrator init: 2 0 0 17)
					)
				)
			)
			(6 (EcoNarrator init: 2 0 0 20))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance topOfWhale of EcoFeature
	(properties
		onMeCheck $0004
		lookStr 2
	)
)

(instance cable of EcoView
	(properties
		x 227
		y 77
		sightAngle 0
		view 642
		loop 3
		priority 1
		signal $4011
		lookStr 4
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 2 0 0 1))
			(44 (EcoNarrator init: 2 0 0 1))
			(6 (EcoNarrator init: 2 0 0 19))
			(2 (EcoNarrator init: 2 0 0 21))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (onMe param1)
		(proc999_4 221 74 229 189 param1)
	)
)
