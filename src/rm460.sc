;;; Sierra Script 1.0 - (do not remove this comment)
(script# 460)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use n958)
(use StopWalk)
(use Grooper)
(use Cycle)
(use InvI)
(use User)
(use Obj)

(public
	rm460 0
	stopGroop 1
)

(local
	local0
	local1
	local2
	local3
)
(instance rm460 of EcoRoom
	(properties
		picture 460
		style $0007
		horizon 10
		south 440
		picAngle 70
		vanishingX 180
		vanishingY 44
	)
	
	(method (init)
		(proc958_0 132 461 462 463 464 465 466 467)
		(= global250 1)
		(gFeatures
			add: Skeleton Grass Sky CoveExit Cliff Beach
			eachElementDo: #init
		)
		(if ((Inv at: 24) ownedBy: 460)
			(proc819_3 18)
			(= local0 0)
			(ppike init:)
			(= local2 1)
			(theGlint init:)
			(gFeatures add: Glint eachElementDo: #init)
		else
			(= local0 2)
		)
		(chest init:)
		(rollingWater init:)
		(gEgo
			view: 461
			loop: 0
			cel: 0
			posn: 118 115
			z: 0
			ignoreActors: 1
			setSpeed: 3
			init:
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						185
						110
						204
						102
						208
						92
						209
						87
						196
						88
						196
						92
						176
						93
						161
						87
						159
						88
						159
						92
						133
						96
						132
						99
					yourself:
				)
		)
		(self setScript: enterFromGoodReef1)
		(super init:)
		(gLongSong number: 460 loop: -1 play:)
		((gIconBar at: 0) loop: 9)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script 0)
			((& (gEgo onControl: 0) $0040) (self setScript: leaveCove))
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 2))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		((gIconBar at: 0) loop: 0)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance ppike of EcoProp
	(properties
		x 116
		y 59
		approachX 147
		approachY 92
		view 460
		signal $4000
	)
	
	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setPri: 4 setLoop: 1 setCel: 0)
		(self approachVerbs: 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (== local0 0)
					(rm460 setScript: doPikeFirst)
				else
					(rm460 setScript: doPikeSecond)
				)
			)
			(1
				(if (gCast contains: theGlint) (theGlint setCycle: Beg))
				(EcoNarrator init: 1 0 0 11)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance chest of EcoProp
	(properties
		x 160
		y 86
		view 460
		signal $4000
	)
	
	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setLoop: 2 setPri: 3)
		(if (proc819_5 41)
			(self setCel: 1)
		else
			(self setCel: 0)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 41)
					((ScriptID 2 1) init: 2 0 0 14 1)
				else
					(self setScript: openChest)
				)
			)
			(1
				(if (not (proc819_5 321)) (theGlint setCycle: Beg))
				(if (proc819_5 41)
					(EcoNarrator init: 1 0 0 6)
				else
					(self setScript: lookChestTalk)
				)
			)
			(44
				(switch temp0
					(33
						(self setScript: useKeyOnChestTalk)
					)
					(37
						(EcoNarrator init: 1 0 0 27)
					)
					(else 
						(EcoNarrator init: 1 0 0 28)
					)
				)
			)
			(2 (EcoNarrator init: 1 0 0 31))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance rollingWater of EcoProp
	(properties
		x 121
		y 108
		nsTop 109
		nsLeft 82
		nsBottom 138
		nsRight 190
		view 4611
		signal $4000
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			setLoop: 0
			setCycle: Fwd
			cycleSpeed: 16
			detailLevel: 2
			setPri: 4
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (rm460 setScript: leaveCove))
			(1
				(if (and (== local0 2) local2)
					((ScriptID 2 1) init: 2 0 0 16 1)
				else
					(EcoNarrator init: 1 0 0 15)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance theGlint of EcoProp
	(properties
		x 122
		y 81
		view 823
		loop 1
		priority 4
		signal $4010
	)
	
	(method (doVerb)
		(Glint doVerb: &rest)
	)
)

(instance KeyInset of EcoProp
	(properties
		x 157
		y 155
		view 460
		priority 15
		signal $5010
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
			(and
				(gUser controls?)
				(gUser input?)
				(!= (pEvent type?) evVERB)
				(!= (pEvent message?) KEY_TAB)
				(not (self onMe: pEvent))
				(not (pEvent modifiers?))
			)
			(pEvent claimed: 1)
			((global2 script?) cue:)
			(proc0_4 5 323)
		else
			(super handleEvent: pEvent &rest)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				((ScriptID 2 1) init: 2 0 0 8 1)
			)
			(1 (EcoNarrator init: 1 0 0 24))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance CoveExit of EcoFeature
	(properties
		x 170
		y 106
		nsTop 102
		nsLeft 163
		nsBottom 110
		nsRight 181
		onMeCheck $0040
	)
)

(instance Skeleton of EcoFeature
	(properties
		x 122
		y 72
		nsTop 51
		nsLeft 110
		nsBottom 93
		nsRight 133
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 18))
			(2 (EcoNarrator init: 1 0 0 29))
			(1
				(if (== local0 2)
					(EcoNarrator init: 1 0 0 4)
				else
					(EcoNarrator init: 1 0 0 3)
				)
			)
			(44
				(switch temp0
					(29
						(EcoNarrator init: 1 0 0 22)
					)
					(37
						(EcoNarrator init: 1 0 0 32)
					)
					(12
						(EcoNarrator init: 1 0 0 34)
					)
					(30
						(EcoNarrator init: 1 0 0 35)
					)
					(else 
						(EcoNarrator init: 1 0 0 33)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Sky of EcoFeature
	(properties
		x 125
		y 10
		nsLeft 60
		nsBottom 20
		nsRight 190
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 17))
			(1 (EcoNarrator init: 1 0 0 20))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Cliff of EcoFeature
	(properties
		x 247
		y 89
		nsTop 22
		nsLeft 202
		nsBottom 156
		nsRight 293
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 16))
			(4 (EcoNarrator init: 1 0 0 14))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Grass of EcoFeature
	(properties
		x 159
		y 178
		nsTop 167
		nsBottom 189
		nsRight 318
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 16))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Glint of EcoFeature
	(properties
		x 115
		y 160
		z 80
		nsTop 73
		nsLeft 110
		nsBottom 83
		nsRight 120
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(global2 setScript: popKeyInset 0 theVerb)
			)
			(1
				(global2 setScript: popKeyInset 0 theVerb)
			)
			(else 
				(theGlint setCycle: Beg)
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Beach of EcoFeature
	(properties
		x 166
		y 98
		nsTop 92
		nsLeft 129
		nsBottom 104
		nsRight 204
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(rm460 setScript: lookBeachTalk)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance stopGroop of Grooper
	(properties)
	
	(method (doit)
		(if
			(and
				(IsObject (gEgo cycler?))
				((gEgo cycler?) isKindOf: StopWalk)
			)
			(gEgo view: ((gEgo cycler?) vStopped?))
		)
		(super doit: &rest)
	)
)

(instance lookChestTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 1 0 0 5 self)
			)
			(1
				(EcoNarrator init: 1 0 0 12 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance useKeyOnChestTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 1 0 0 1 self)
			)
			(1
				(EcoNarrator init: 1 0 0 19 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance lookBeachTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(EcoNarrator init: 1 0 0 8 self)
			)
			(1
				(EcoNarrator init: 1 0 0 9 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance enterFromGoodReef1 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= ticks 15))
			(1
				(gSoundEffects number: 461 loop: 1 play:)
				(gEgo
					view: 461
					posn: 118 115
					loop: 0
					cel: 0
					z: 0
					signal: 16384
					setStep: 3 2
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(self setScript: shakeFins self)
			)
			(3
				(gEgo
					posn: 148 96
					view: 806
					loop: stopGroop
					setCycle: StopWalk 819
					priority: 5
					signal: 16400
					cycleSpeed: 2
				)
				(= cycles 2)
			)
			(4 (proc0_2) (self dispose:))
		)
	)
)

(instance shakeFins of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 159 108 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gSoundEffects number: 462 loop: 1 play:)
				(gEgo cel: 3 setCycle: CT 7 1 self)
			)
			(2
				(gSoundEffects number: 462 loop: 1 play:)
				(gEgo cel: 8 setCycle: CT 13 1 self)
			)
			(3 (self dispose:))
		)
	)
)

(instance doPikeFirst of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo view?) 819)
					(gEgo
						view: 806
						setLoop: stopGroop
						setCycle: StopWalk 819
						priority: 5
						signal: 16400
						cycleSpeed: 2
						setMotion: PolyPath 148 96 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(ppike hide:)
				(gEgo
					view: 461
					posn: 126 82
					loop: 2
					cel: 0
					ignoreActors: 1
					cycleSpeed: 15
					setCycle: End self
				)
				(= local0 1)
			)
			(2
				(gSoundEffects number: 464 loop: 1 play:)
				(ppike show:)
				(gEgo posn: 126 82 loop: 3 cel: 0 setCycle: CT 4 1 self)
				(proc0_4 2 320)
			)
			(3
				(gSoundEffects number: 465 loop: 1 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(4 (= ticks 120))
			(5
				(gSoundEffects number: 461 loop: 1 play:)
				(gEgo posn: 118 115 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(self setScript: scratchSelf self)
			)
			(7 (= ticks 60))
			(8
				(self setScript: shakeFins self)
			)
			(9
				(gEgo
					posn: 147 95
					view: 806
					setLoop: stopGroop
					priority: 5
					signal: 16400
					cycleSpeed: 2
					setCycle: StopWalk 819
				)
				(= cycles 1)
			)
			(10
				((ScriptID 2 1) init: 2 0 0 15 1 self)
			)
			(11 (self dispose:))
		)
	)
)

(instance scratchSelf of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 144 96 loop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(if (<= (++ local3) 4)
					(-- state)
					(gSoundEffects number: 463 loop: 1 play:)
					(gEgo cel: (+ 2 (== (gEgo cel?) 2)))
				)
				(= cycles 4)
			)
			(2
				(gSoundEffects stop:)
				(gEgo setCycle: Beg self)
			)
			(3 (self dispose:))
		)
	)
)

(instance doPikeSecond of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(if (== (gEgo view?) 819)
					(gEgo
						view: 806
						setLoop: stopGroop
						setCycle: StopWalk 819
						priority: 5
						signal: 16400
						cycleSpeed: 2
						setMotion: PolyPath 147 92 self
					)
				)
			)
			(1
				(gEgo setCycle: 0 cel: 4)
				(= ticks 4)
			)
			(2
				(ppike hide:)
				(gEgo
					posn: 126 82
					view: 461
					loop: 2
					cel: 0
					ignoreActors: 1
					cycleSpeed: 15
					setCycle: End self
				)
				(= local0 2)
			)
			(3
				(gEgo posn: 126 82 loop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(gSoundEffects number: 466 loop: 1 play:)
				(gEgo setCycle: End self)
				(proc819_4 18)
				(proc819_3 19)
				(ppike dispose:)
				(Glint dispose:)
				(theGlint dispose:)
				(proc0_4 2 321)
			)
			(5
				(EcoNarrator init: 1 0 0 21 self)
			)
			(6
				(rollingWater setScript: showKeyTimer)
				(gEgo
					posn: 180 100
					view: 806
					setLoop: stopGroop
					setCycle: StopWalk 819
					priority: 5
					signal: 16400
					cycleSpeed: 2
					setMotion: PolyPath 160 100 self
				)
			)
			(7
				((Inv at: 24) owner: 440)
				(= ticks 60)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance showKeyTimer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc819_3 44)
				(= ticks 840)
			)
			(1
				(proc819_4 44)
				(self dispose:)
			)
		)
	)
)

(instance openChest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo
					view: 806
					setLoop: stopGroop
					setCycle: StopWalk 819
					ignoreActors: 1
					cycleSpeed: 2
					setMotion: PolyPath 159 68 self
				)
			)
			(1
				(gEgo loop: 0 cel: 4)
				(= ticks 3)
			)
			(2
				(EcoNarrator init: 1 0 0 25 self)
			)
			(3
				(chest hide:)
				(gEgo
					view: 461
					loop: 6
					cel: 0
					posn: 159 68
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(4
				(gSoundEffects number: 467 loop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(5
				(gSoundEffects number: 469 loop: 1 flags: 1 play:)
				(gEgo setCycle: End self)
			)
			(6
				(gSoundEffects stop: flags: 0)
				(EcoNarrator init: 1 0 0 26 self)
			)
			(7
				(chest setCel: 1 show:)
				(gSoundEffects number: 468 loop: 1 play:)
				(gEgo loop: 7 cel: 0 cycleSpeed: 18 setCycle: End self)
			)
			(8
				(gEgo
					posn: 155 95
					view: 806
					loop: 0
					priority: 5
					signal: 16400
					cycleSpeed: 4
					setCycle: StopWalk 819
				)
				(proc0_4 5 322)
				(= cycles 1)
			)
			(9
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(10
				(proc819_3 41)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance leaveCove of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo
					view: 806
					setLoop: stopGroop
					setCycle: StopWalk 819
					priority: 5
					signal: 16400
					cycleSpeed: 6
					setMotion: PolyPath 171 99 self
				)
			)
			(1
				(gEgo
					posn: 148 84
					view: 461
					loop: 8
					cel: 0
					cycleSpeed: 16
					setCycle: CT 5 1 self
				)
			)
			(2
				(gSoundEffects number: 461 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3 (gEgo hide:) (= ticks 120))
			(4
				(proc0_2)
				(global2 newRoom: 440)
				(self dispose:)
			)
		)
	)
)

(instance popKeyInset of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 1 canInput: 1)
				(gIconBar disable: 5 0 3 4 5)
				(KeyInset init:)
				(= cycles 2)
			)
			(1 (KeyInset doVerb: register))
			(2
				(KeyInset dispose:)
				(= cycles 3)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)
