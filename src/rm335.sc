;;; Sierra Script 1.0 - (do not remove this comment)
(script# 335)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use Smopper)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use User)
(use Obj)

(public
	rm335 0
)

(procedure (localproc_110e)
	(fisherman
		view: 328
		loop: 2
		cel: 0
		x: 122
		y: 111
		cycleSpeed: 12
		setCycle: End
	)
)

(instance rm335 of EcoRoom
	(properties
		picture 320
		style $8007
		horizon 95
		south 341
		lookStr 14
	)
	
	(method (init)
		(proc958_0 128 241 323 328 811 825 249 329 330)
		(= global250 4)
		(manatee init: hide:)
		(if (proc819_5 43) (manatee show:))
		(proc819_6)
		(gEgo
			view: 825
			setLoop: gStopGroop
			setCycle: Walk
			setStep: 4 2
			setHeading: 0
			init:
			hide:
		)
		(fisherman init: setCycle: Fwd)
		(ripples init: setCycle: Fwd)
		(rope init:)
		(propeller init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 56 133 42 93 0 93 0 0 319 0 319 91 266 91 259 123 163 147 108 146
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 51 163 110 163 110 175 51 175
					yourself:
				)
		)
		(if (not (proc819_5 43))
			(global2 setScript: cartoon)
		else
			(global2 setScript: fromBelow)
		)
		(super init: &rest)
		(boat addToPic:)
		(gLongSong number: 923 loop: -1 play:)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script 0)
			((proc999_5 (gEgo edgeHit?) 2 4 1) (global2 setScript: cantGoThatWay))
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 14))
			(6
				(if (> ((User curEvent?) y?) 67)
					(EcoNarrator init: 4 0 0 12)
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

(instance fromBelow of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 2))
			(1
				(manatee cycleSpeed: 17 setCycle: Fwd)
				(gEgo
					show:
					view: 811
					loop: 2
					cel: 0
					posn: 171 167
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 825
					setLoop: gStopGroop
					loop: 3
					cel: 0
					posn: 171 167
					setCycle: Smopper 825 0 0 12
				)
				(= seconds 1)
			)
			(3
				(EcoNarrator init: 4 0 0 26 self)
			)
			(4
				(Gregarious init: 1 0 0 5 1 self)
			)
			(5 (proc0_2) (self dispose:))
		)
	)
)

(instance cartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 2))
			(1
				(manatee
					show:
					view: 241
					loop: 2
					x: 71
					y: 171
					cycleSpeed: 10
					setCycle: CT 3 1 self
				)
			)
			(2
				(manatee cycleSpeed: 23 setCycle: End self)
			)
			(3
				(manatee
					view: 241
					loop: 3
					x: 71
					y: 171
					cycleSpeed: 23
					setCycle: Fwd
				)
				(= seconds 1)
			)
			(4
				(gEgo
					show:
					view: 811
					loop: 2
					cel: 0
					posn: 171 167
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(5
				(gEgo
					view: 825
					setLoop: gStopGroop
					loop: 3
					cel: 0
					posn: 171 167
					setCycle: Smopper 825 0 0 12
				)
				(= cycles 3)
			)
			(6
				(Gregarious init: 1 0 0 1 1 self)
			)
			(7
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(8
				(Gregarious init: 1 0 0 2 1 self)
			)
			(9
				(proc819_3 43)
				(proc819_4 40)
				(= cycles 1)
			)
			(10 (proc0_2) (self dispose:))
		)
	)
)

(instance talkToFisherman of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 142 149 self)
			)
			(1 (gEgo setHeading: 0 self))
			(2
				(proc0_4 2 300)
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(3
				(Fisherman init: 3 0 0 1 1 self)
			)
			(4
				(fisherman
					view: 328
					loop: 1
					cel: 0
					x: 122
					y: 111
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(5
				(localproc_110e)
				(= seconds 2)
			)
			(6
				((ScriptID 2 1) init: 2 0 0 3 1 self)
			)
			(7
				(Fisherman init: 3 0 0 2 1 self)
			)
			(8
				((ScriptID 2 1) init: 2 0 0 4 1 self)
			)
			(9
				(Fisherman init: 3 0 0 3 1 self)
			)
			(10
				(localproc_110e)
				(= seconds 2)
			)
			(11
				((ScriptID 2 1) init: 2 0 0 5 1 self)
			)
			(12
				(Fisherman init: 3 0 0 4 1 self)
			)
			(13
				(localproc_110e)
				(= seconds 2)
			)
			(14
				((ScriptID 2 1) init: 2 0 0 6 1 self)
			)
			(15
				(Fisherman init: 3 0 0 5 1 self)
			)
			(16
				((ScriptID 2 1) init: 2 0 0 7 1 self)
			)
			(17
				(Fisherman init: 3 0 0 6 1 self)
			)
			(18
				(if (== (global2 script?) cageOnFisherman)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(19
				(proc819_3 34)
				(fisherman cycleSpeed: 12 setCycle: Fwd)
				(= cycles 1)
			)
			(20 (proc0_2) (self dispose:))
		)
	)
)

(instance useSteelCage of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 1) init: 2 0 0 11 1 self)
			)
			(1
				(Gregarious init: 1 0 0 7 1 self)
			)
			(2
				(gEgo setMotion: PolyPath 142 149 self)
			)
			(3
				(EcoNarrator init: 4 0 0 29 self)
			)
			(4 (= cycles 5))
			(5
				(manatee
					view: 241
					loop: 4
					cel: 4
					x: 71
					y: 171
					cycleSpeed: 14
					setCycle: Beg self
				)
				(gEgo
					setCycle: 0
					view: 811
					loop: 2
					cel: 3
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(6 0)
			(7 (gEgo hide:) (= cycles 1))
			(8
				(manatee hide:)
				(= cycles 1)
			)
			(9
				(NSET init:)
				(manatee
					show:
					view: 330
					loop: 1
					cel: 0
					cycleSpeed: 15
					posn: 149 132
					setPri: 14
					ignoreActors:
					setCycle: End self
				)
			)
			(10
				(gSoundEffects number: 334 loop: 1 play:)
				(gEgo
					setCycle: 0
					view: 330
					loop: 2
					cel: 0
					posn: 168 116
					cycleSpeed: 15
					setPri: 15
					ignoreActors:
					show:
					setCycle: End self
				)
			)
			(11
				(EcoNarrator posn: -1 15 init: 4 0 0 1 self)
			)
			(12
				(proc0_4 5 299)
				(NSET dispose:)
				(manatee
					view: 241
					loop: 4
					x: 71
					y: 171
					cycleSpeed: 14
					setCycle: End self
				)
				(gEgo
					put: 0 335
					view: 811
					loop: 2
					cel: 0
					posn: 171 167
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(13 0)
			(14
				(manatee
					view: 241
					loop: 3
					x: 71
					y: 171
					cycleSpeed: 23
					setCycle: Fwd
				)
				(gEgo
					view: 825
					setLoop: gStopGroop
					loop: 3
					cel: 0
					posn: 171 167
					setCycle: Smopper 825 0 0 12
				)
				(= cycles 3)
			)
			(15
				(Fisherman init: 3 0 0 9 1 self)
			)
			(16
				((ScriptID 2 1) init: 2 0 0 8 1 self)
			)
			(17
				(Fisherman init: 3 0 0 10 1 self)
			)
			(18
				((ScriptID 2 1) init: 2 0 0 9 1 self)
			)
			(19
				(proc819_4 43)
				(proc0_2)
				(global2 newRoom: 341)
			)
		)
	)
)

(instance cantGoThatWay of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_1) (= cycles 1))
			(1
				(EcoNarrator init: 4 0 0 2 self)
			)
			(2
				(cond 
					((== (gEgo edgeHit?) 4) (gEgo setMotion: MoveTo (+ (gEgo x?) 5) (gEgo y?) self))
					((== (gEgo edgeHit?) 2) (gEgo setMotion: MoveTo (- (gEgo x?) 5) (gEgo y?) self))
					((== (gEgo edgeHit?) 1) (gEgo setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 3) self))
				)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance cageOnFisherman of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc819_5 34)
					((ScriptID 2 1) init: 2 0 0 10 1 self)
				else
					(self setScript: talkToFisherman self)
				)
			)
			(1
				(if (proc819_5 34)
					(= cycles 1)
				else
					((ScriptID 2 1) init: 2 0 0 12 1 self)
				)
			)
			(2
				(Fisherman init: 3 0 0 16 1 self)
			)
			(3
				(if (not (proc819_5 34)) (proc0_2))
				(= cycles 1)
			)
			(4
				(proc819_3 34)
				(self dispose:)
			)
		)
	)
)

(instance propeller of EcoFeature
	(properties
		x 94
		y 157
		z 26
		nsTop 120
		nsLeft 77
		nsBottom 142
		nsRight 112
		sightAngle 90
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 21))
			(4 (EcoNarrator init: 4 0 0 22))
			(6 (EcoNarrator init: 4 0 0 9))
			(44
				(switch temp0
					(9
						(if (proc819_5 42)
							(if (proc819_5 34)
								(global2 setScript: useSteelCage)
							else
								(EcoNarrator init: 4 0 0 31)
							)
						else
							(EcoNarrator init: 4 0 0 4)
						)
					)
					(13
						(EcoNarrator init: 4 0 0 30)
					)
					(29
						(EcoNarrator init: 4 0 0 23)
					)
					(14
						(EcoNarrator init: 4 0 0 23)
					)
					(else 
						(EcoNarrator init: 4 0 0 24)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance rope of EcoFeature
	(properties
		x 152
		y 118
		sightAngle 90
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 18))
			(4 (EcoNarrator init: 4 0 0 19))
			(44
				(EcoNarrator init: 4 0 0 20)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (onMe param1)
		(if
			(or
				(proc999_4 149 114 122 155 param1)
				(proc999_4 153 123 156 129 param1)
			)
		else
			(proc999_4 154 130 159 139 param1)
		)
	)
)

(instance boat of EcoView
	(properties
		x 65
		y 76
		view 323
		priority 8
		signal $1011
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 13))
			(4 (EcoNarrator init: 4 0 0 7))
			(6 (EcoNarrator init: 4 0 0 9))
			(44
				(switch temp0
					(9 (EcoNarrator init: 4 0 0 3))
					(13
						(EcoNarrator init: 4 0 0 17)
					)
					(else 
						(EcoNarrator init: 4 0 0 15)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fisherman of EcoProp
	(properties
		x 139
		y 111
		view 328
		priority 8
		signal $1010
		cycleSpeed 16
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 28))
			(4 (EcoNarrator init: 4 0 0 6))
			(2
				(if (not (proc819_5 34))
					(global2 setScript: talkToFisherman)
				else
					(Fisherman init: 3 0 0 7 1)
				)
			)
			(6 (EcoNarrator init: 4 0 0 11))
			(44
				(if (not (proc819_5 34))
					(global2 setScript: talkToFisherman)
				else
					(switch temp0
						(9
							(global2 setScript: cageOnFisherman)
						)
						(29 (Fisherman init: 3 0 0 12))
						(14 (Fisherman init: 3 0 0 13))
						(13 (Fisherman init: 3 0 0 15))
						(30
							(EcoNarrator init: 4 0 0 27)
						)
						(else 
							(switch (Random 0 1)
								(0
									(Fisherman init: 3 0 0 11 self)
								)
								(1
									(Fisherman init: 3 0 0 8 self)
								)
							)
						)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance ripples of EcoProp
	(properties
		x 143
		y 129
		onMeCheck $0000
		view 323
		loop 1
		priority 2
		signal $5010
		cycleSpeed 18
		detailLevel 2
	)
)

(instance manatee of EcoProp
	(properties
		x 71
		y 171
		view 241
		loop 3
		signal $1000
		cycleSpeed 9
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 4 0 0 25))
			(4 (EcoNarrator init: 4 0 0 8))
			(2 (Gregarious init: 1 0 0 6))
			(6 (EcoNarrator init: 4 0 0 10))
			(44
				(switch temp0
					(9 (Gregarious init: 1 0 0 3))
					(13 (Gregarious init: 1 0 0 3))
					(else 
						(Gregarious init: 1 0 0 4)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance NSET of EcoView
	(properties
		x 91
		y 69
		view 330
		priority 13
		signal $4011
	)
)

(instance Gregarious of EcoTalker
	(properties
		nsTop 50
		nsLeft 5
		view 249
		charNum 7
		keepWindow 1
	)
	
	(method (init)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of EcoProp
	(properties
		view 249
	)
)

(instance gEyes of EcoProp
	(properties
		nsTop 13
		nsLeft 13
		view 249
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of EcoProp
	(properties
		nsTop 16
		nsLeft 9
		view 249
		loop 1
		cycleSpeed 10
	)
)

(instance Fisherman of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 329
		charNum 9
		keepWindow 1
	)
	
	(method (init)
		(super init: fBust fEyes fMouth &rest)
	)
)

(instance fBust of EcoProp
	(properties
		view 329
	)
)

(instance fEyes of EcoProp
	(properties
		nsTop 21
		nsLeft 17
		view 329
		loop 2
		cycleSpeed 30
	)
)

(instance fMouth of EcoProp
	(properties
		nsTop 18
		nsLeft 8
		view 329
		loop 1
		cycleSpeed 10
	)
)
