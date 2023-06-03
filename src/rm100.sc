;;; Sierra Script 1.0 - (do not remove this comment)
(script# 100)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Polygon)
(use n958)
(use Cycle)
(use User)
(use Obj)

(public
	rm100 0
)

(local
	local0
	local1
	local2
	local3
)
(procedure (localproc_0098 param1 param2)
	(= local0 param1)
	(= local1 param2)
)

(procedure (localproc_00a1 param1 param2)
	(= local2 param1)
	(= local3 param2)
)

(instance rm100 of EcoRoom
	(properties
		picture 100
		style $8007
		horizon 15
		lookStr 37
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(= global225 2)
		(proc819_6)
		(if (not (proc819_5 73))
			(proc819_7)
			(gDelph z: 0)
			(gDelph init: lookStr: 36 talkScript: delTalkScript)
		)
		(gEgo init:)
		(proc958_0 128 834 809)
		(gFeatures
			add:
				BigHead
				eluriaCity
				eluriaOutskirts
				closeColumn
				coral
				pillars
				soldierMask
				moss
			eachElementDo: #init
		)
		(plant setCycle: Fwd init:)
		(if (and (proc819_5 7) (!= global233 2))
			(leaves setCycle: Fwd init:)
			(glow setCycle: Fwd init:)
		)
		(super init:)
		(proc0_1)
		(global2
			addObstacle:
				((Polygon new:)
					type: 0
					init: 77 69 103 35 120 35 135 41 177 41 218 61 213 74 184 94 131 94 94 85
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						256
						79
						268
						30
						220
						-10
						319
						-10
						319
						189
						213
						189
						213
						185
						271
						185
						271
						138
						200
						138
						216
						113
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 -10 108 -10 91 20 52 29 5 189 0 189
					yourself:
				)
			setRegions: 51
		)
		(switch gSouth
			(120
				(gEgo posn: 162 83 loop: 2 setCycle: Walk)
				(localproc_0098 162 107)
				(if (not (proc819_5 73))
					(localproc_00a1 64 119)
					(gDelph posn: 129 78)
				)
			)
			(420
				(gEgo posn: 225 144 loop: 1 setCycle: Walk)
				(localproc_0098 196 144)
				(if (not (proc819_5 73))
					(localproc_00a1 64 121)
					(gDelph posn: 250 165)
				)
			)
			(else 
				(gEgo posn: 98 217)
				(if (not (proc819_5 73))
					(gDelph posn: 151 200)
					(localproc_00a1 163 119)
				)
				(if (not (proc819_5 6))
					(gLongSong number: 100 loop: 1 play: glow)
					(gEgo setCycle: Walk)
					(localproc_0098 80 133)
					(enterScript next: enjoyViewOfCity)
				else
					(localproc_0098 98 167)
				)
			)
		)
		(if (proc819_5 6)
			(gLongSong number: 101 loop: 1 play: glow)
		)
		(self setScript: enterScript)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond 
			(script 0)
			((& temp0 $1000) (self setScript: enterCity))
			((& temp0 $4000) (self newRoom: 420))
			((== (gEgo edgeHit?) 3) (self setScript: tryToGoSouth))
			((== (gEgo edgeHit?) 1) (global2 setScript: NoExit))
		)
	)
	
	(method (newRoom newRoomNumber)
		(gDelph talkScript: 0 lookStr: 0)
		(gLongSong client: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (init)
		(if local2 (gDelph setScript: delEnterScript))
		(super init: &rest)
	)
	
	(method (dispose)
		(if (gDelph script?) (gDelph setScript: 0))
		(super dispose: &rest)
	)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(= cycles (= cycles (= cycles (= cycles 1))))
			)
			(1
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(2
				(if (and (proc819_5 6) (not (proc819_3 115)))
					(self setScript: wereOnOurOwn self)
				else
					(= ticks (= ticks (= ticks (= ticks 3))))
				)
			)
			(3
				(if (not next) (proc819_6) (proc0_2))
				(self dispose:)
			)
		)
	)
)

(instance wereOnOurOwn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(= cycles (= cycles (= cycles (= cycles 3))))
			)
			(1
				((ScriptID 2 0) init: 1 0 0 4 1 self)
			)
			(2
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(3
				((ScriptID 2 0) init: 1 0 0 5 0 self)
			)
			(4
				((ScriptID 2 0) init: 1 0 0 6 1 self)
			)
			(5
				((ScriptID 2 1) init: 2 0 0 3 1 self)
			)
			(6
				(= cycles (= cycles (= cycles (= cycles 4))))
			)
			(7 (self dispose:))
		)
	)
)

(instance enjoyViewOfCity of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(= seconds (= seconds (= seconds (= seconds 4))))
			)
			(1
				(proc0_4 15 250)
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(2
				((ScriptID 2 0) init: 1 0 0 1 1 self)
			)
			(3
				(gDelph setScript: delEnterCity)
				(client setScript: enterCity)
			)
		)
	)
)

(instance enterCity of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(gEgo setCycle: Walk setHeading: 0 self)
			)
			(1
				(gEgo
					view: 809
					cel: 0
					setLoop: (not (proc819_5 6))
					setCycle: End self
					setMotion: MoveTo 155 87 self
				)
			)
			(2 0)
			(3
				(proc0_2)
				(global2 newRoom: 120)
			)
		)
	)
)

(instance delEnterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(= cycles (= cycles (= cycles (= cycles 1))))
			)
			(1
				(gDelph setMotion: MoveTo local2 local3 self)
			)
			(2
				(if (not next)
					(proc819_9 gDelph gEgo self)
				else
					(= ticks (= ticks (= ticks (= ticks 2))))
				)
			)
			(3
				(gDelph cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance delEnterCity of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(gDelph
					setCycle: 0
					view: 834
					setLoop: 0
					cel: 0
					setCycle: End self
					setMotion: MoveTo 162 74 self
				)
			)
			(1 0)
			(2 (self dispose:))
		)
	)
)

(instance tryToGoSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(= cycles (= cycles (= cycles (= cycles 1))))
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 3 0 0 34 self)
				else
					((ScriptID 2 0) init: 1 0 0 2 1 self)
				)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x?) 175 self)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance NoExit of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(if (not (proc819_5 73))
					((ScriptID 2 0) init: 1 0 0 3 1 self)
				else
					(EcoNarrator init: 3 0 0 35 self)
				)
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

(instance delTalkScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				((ScriptID 2 0) init: 1 0 0 38 1 self)
			)
			(1 (proc0_2) (self dispose:))
		)
	)
)

(instance BigHead of EcoFeature
	(properties
		onMeCheck $0002
		lookStr 1
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 2))
			(44 (EcoNarrator init: 3 0 0 2))
			(6 (EcoNarrator init: 3 0 0 2))
			(2 (EcoNarrator init: 3 0 0 5))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eluriaCity of EcoFeature
	(properties
		onMeCheck $1004
		lookStr 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(6 (EcoNarrator init: 3 0 0 4))
			(2 (EcoNarrator init: 3 0 0 6))
			(44 (EcoNarrator init: 3 0 0 7))
			(4 (EcoNarrator init: 3 0 0 16))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eluriaOutskirts of EcoFeature
	(properties
		onMeCheck $0008
		lookStr 15
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(2 (EcoNarrator init: 3 0 0 19))
			(44
				(EcoNarrator init: 3 0 0 18)
			)
			(6 (EcoNarrator init: 3 0 0 22))
			(4 (EcoNarrator init: 3 0 0 17))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance closeColumn of EcoFeature
	(properties
		onMeCheck $0010
		lookStr 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 12))
			(44
				(EcoNarrator init: 3 0 0 12)
			)
			(2 (EcoNarrator init: 3 0 0 13))
			(6 (EcoNarrator init: 3 0 0 14))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance glow of EcoProp
	(properties
		x 290
		y 107
		view 100
		priority 10
		signal $4010
		cycleSpeed 15
		lookStr 2
	)
	
	(method (cue)
		(gLongSong number: 420 loop: -1 play:)
	)
)

(instance leaves of EcoProp
	(properties
		x 281
		y 100
		view 100
		loop 1
		priority 10
		signal $4010
		cycleSpeed 12
		detailLevel 2
		lookStr 8
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 9))
			(44
				(EcoNarrator init: 3 0 0 10)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance plant of EcoProp
	(properties
		x 258
		y 5
		view 100
		loop 2
		signal $4010
		cycleSpeed 12
		detailLevel 2
		lookStr 8
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 9))
			(44
				(EcoNarrator init: 3 0 0 10)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance pillars of EcoFeature
	(properties
		onMeCheck $0040
		lookStr 20
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 21))
			(44
				(EcoNarrator init: 3 0 0 21)
			)
			(6 (EcoNarrator init: 3 0 0 22))
			(2 (EcoNarrator init: 3 0 0 23))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance coral of EcoFeature
	(properties
		y 190
		onMeCheck $0080
		lookStr 24
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 25))
			(44
				(EcoNarrator init: 3 0 0 26)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance soldierMask of EcoFeature
	(properties
		onMeCheck $0100
		lookStr 29
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= x (= x (= x (= x ((User curEvent?) x?)))))
		(= y (= y (= y (= y ((User curEvent?) y?)))))
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 30))
			(44
				(EcoNarrator init: 3 0 0 31)
			)
			(6 (EcoNarrator init: 3 0 0 32))
			(2 (EcoNarrator init: 3 0 0 33))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance moss of EcoFeature
	(properties
		onMeCheck $0200
		lookStr 27
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (proc999_5 theVerb 44 4)
			(EcoNarrator init: 3 0 0 28)
		else
			(super doVerb: theVerb temp0 &rest)
		)
	)
)
