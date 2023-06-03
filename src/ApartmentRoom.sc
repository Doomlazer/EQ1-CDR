;;; Sierra Script 1.0 - (do not remove this comment)
(script# 227)
(include sci.sh)
(use Main)
(use n804)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use MoveFwd)
(use Cycle)
(use User)
(use Obj)

(public
	enterScript 0
	exitScript 1
)

(class ApartmentRoom of ERoom
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		picture 0
		style $ffff
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY 0
		obstacles 0
		inset 0
		lookStr 0
	)
	
	(method (init &tmp temp0)
		(super init:)
		(rock_1 addToPic:)
		(rock_2 addToPic:)
		(rock_3 addToPic:)
		(rock_4 addToPic:)
		(aptExit init:)
		(proc819_6)
		(gEgo init: view: 802 posn: 323 203)
		(if (not (global2 script?))
			(global2 setScript: (ScriptID 227 0))
			(if
				(= temp0
					(switch gNumber
						(221 201)
						(222 205)
						(223 203)
						(224 202)
						(225 204)
						(226
							(if (proc819_5 53) 206 else 207)
						)
					)
				)
				(gLongSong number: temp0 loop: -1 play:)
			)
		)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script (script doit:))
			(
				(= temp0
					(switch ((User alterEgo?) edgeHit?)
						(1 (global2 north?))
						(2 (global2 east?))
						(3 (global2 south?))
						(4 (global2 west?))
					)
				)
				(global2 setScript: (ScriptID 227 1) 0 temp0)
			)
		)
	)
	
	(method (dispose)
		(gLongSong fade:)
		(super dispose:)
		(DisposeScript 227)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if lookStr
					(EcoNarrator init: global250 0 0 lookStr 0 gNumber)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(6
				(EcoNarrator init: 1 0 0 (Random 121 124) 0 4)
			)
			(2
				(EcoNarrator init: 1 0 0 (Random 130 134) 0 4)
			)
			(4
				(EcoNarrator init: 1 0 0 (Random 125 129) 0 4)
			)
			(44
				(EcoNarrator init: 2 0 1 (Random 1 3) 0 4)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (newRoom)
		(proc0_1)
		(super newRoom: &rest)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose: &rest)
		(global2 notify:)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo ignoreActors: 1)
				(= cycles (= cycles 2))
			)
			(1
				(gEgo setMotion: MoveTo 271 172 self)
			)
			(2 (= cycles (= cycles 5)))
			(3 (self dispose:))
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== state 0)
				(or (> (gEgo nsLeft?) 320) (> (gEgo nsTop?) 190))
			)
			(= cycles (= cycles 1))
		)
	)
	
	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gEgo
					ignoreActors: 1
					setCycle: Walk
					setHeading: 135
					setMotion: MoveFwd 200
				)
			)
			(1 (global2 newRoom: register))
		)
	)
)

(instance rock_1 of EcoView
	(properties
		x 186
		y 46
		onMeCheck $0000
		view 220
		loop 1
		cel 2
		signal $4011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
)

(instance rock_2 of EcoView
	(properties
		x 182
		y 95
		onMeCheck $0000
		view 220
		loop 1
		signal $4011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
)

(instance rock_3 of EcoView
	(properties
		x 170
		y 25
		onMeCheck $0000
		view 220
		loop 1
		cel 1
		signal $4011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
)

(instance rock_4 of EcoView
	(properties
		x 195
		y 27
		onMeCheck $0000
		view 220
		loop 1
		cel 1
		signal $4011
	)
	
	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
)

(instance aptExit of EcoFeature
	(properties
		x 271
		y 183
		nsTop 177
		nsLeft 224
		nsBottom 189
		nsRight 319
	)
	
	(method (doVerb theVerb &tmp temp0 [temp1 120])
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(EcoNarrator init: global250 0 0 10 0 gNumber)
			)
			(4
				(EcoNarrator init: global250 0 0 12 0 gNumber)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)
