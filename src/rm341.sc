;;; Sierra Script 1.0 - (do not remove this comment)
(script# 341)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use MoveFwd)
(use ForwardCounter)
(use n958)
(use Cycle)
(use InvI)
(use Obj)

(public
	rm341 0
)

(local
	[local0 14] = [-1 -1 -30 29 15 360 67 -30 108 4096 0 290 210 -32768]
	[local14 16] = [-1 0 -20 300 0 -30 30 360 35 4096 15 -30 168 195 360 -32768]
	[local30 16] = [-1 1 360 170 15 -20 210 360 183 240 167 8192 -1 -30 156 16384]
)
(instance rm341 of EcoRoom
	(properties
		picture 340
		style $8007
		horizon 20
		north 335
		south 200
	)
	
	(method (init)
		(proc958_0 128 343 231 802)
		(proc819_6)
		(gEgo init: ignoreHorizon: hide:)
		(super init:)
		(self setRegions: 51 50)
		((ScriptID 50 0) addFish: @local14 @local30 @local0)
		(cond 
			((and (proc819_5 40) (not (proc819_5 43))) (global2 setScript: swimThru))
			((== ((Inv at: 0) owner?) 335)
				(= picture (= picture 901))
				(global2 setScript: cagePuzzleDone)
			)
			(else (global2 setScript: enterScript))
		)
		(gLongSong number: 332 loop: -1 play:)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script 0)
			((proc999_5 (gEgo edgeHit?) 2 4) (global2 setScript: cantGoThatWay))
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1 (EcoNarrator init: 1 0 0 4))
			(4 (EcoNarrator init: 1 0 0 5))
			(44 (EcoNarrator init: 1 0 0 5))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(if (== gSouth 335)
					(gEgo setHeading: 180 posn: 160 -20)
				else
					(gEgo setHeading: 0 posn: 160 210)
				)
				(= cycles (= cycles 2))
			)
			(1
				(gEgo show: setMotion: MoveFwd 45 self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance fishShark of EcoActor
	(properties
		x -50
		y 130
		view 50
		detailLevel 1
		illegalBits $0000
		xStep 4
	)
	
	(method (init)
		(if (Random 0 1)
			(self
				ignoreActors: 1
				ignoreHorizon: 1
				setLoop: 0
				setPri: 1
				setCycle: Fwd
				cycleSpeed: 16
				setHeading: 100
				setMotion: MoveTo 475 130 self
			)
		else
			(self
				ignoreActors: 1
				ignoreHorizon: 1
				setLoop: 1
				setPri: 1
				posn: 400 95
				setCycle: Fwd
				cycleSpeed: 16
				setHeading: 100
				setMotion: MoveTo -50 95 self
			)
		)
		(super init: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swimThru of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(bottle init:)
				(manatee setLoop: 3 init:)
				(pump init:)
				(sandwich init:)
				(if (not (Random 0 3)) (fishShark init:))
				(= cycles (= cycles 2))
			)
			(1
				(manatee setCycle: Walk setMotion: MoveTo 145 107)
				(sandwich
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 286 210
				)
				(bottle
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 225 210
				)
				(pump
					setLoop: 0
					setCycle: ForwardCounter 6
					setMotion: MoveTo 154 77 self
				)
				(= cycles (= cycles 20))
			)
			(2 (EcoNarrator init: 1 0 0 1))
			(3
				(gSoundEffects number: 333 loop: 1 play:)
				(gEgo
					posn: 175 260
					setHeading: 0
					show:
					cycleSpeed: 12
					yStep: 2
					setCycle: Walk
					setMotion: MoveTo 175 -25
				)
				(manatee y: (+ (manatee y?) 1))
				(pump
					view: 343
					loop: 3
					cel: 0
					x: 144
					y: 108
					priority: 14
					signal: 16400
				)
				(= cycles (= cycles 3))
			)
			(4
				(Gregarious init: 2 0 0 1 1 self)
			)
			(5
				(manatee y: (+ (manatee y?) 1))
				(pump
					view: 343
					loop: 0
					cel: 1
					x: 150
					y: 81
					priority: 14
					signal: 16400
				)
				(= cycles (= cycles 3))
			)
			(6
				(manatee y: (+ (manatee y?) 1))
				(pump
					view: 343
					loop: 0
					cel: 2
					x: 148
					y: 80
					priority: 14
					signal: 16400
				)
				(= cycles (= cycles 3))
			)
			(7
				(manatee y: (- (manatee y?) 1))
				(pump
					view: 343
					loop: 0
					cel: 3
					x: 146
					y: 81
					priority: 14
					signal: 16400
				)
				(= cycles (= cycles 3))
			)
			(8
				(manatee y: (- (manatee y?) 1))
				(pump
					view: 343
					loop: 0
					cel: 4
					x: 144
					y: 81
					priority: 14
					signal: 16400
				)
				(= cycles (= cycles 3))
			)
			(9
				(manatee y: (- (manatee y?) 1))
				(pump
					view: 343
					loop: 0
					cel: 0
					x: 142
					y: 82
					priority: 14
					signal: 16400
				)
				(= cycles (= cycles 3))
			)
			(10
				(manatee setMotion: MoveTo 145 -50)
				(pump
					setLoop: 0
					yStep: 3
					setCycle: Fwd
					setMotion: MoveTo 142 210 self
				)
			)
			(11
				(proc819_3 65)
				(proc819_3 66)
				(proc819_3 46)
				(pump dispose:)
				(manatee dispose:)
				(proc0_2)
				(global2 newRoom: 335)
			)
		)
	)
)

(instance cagePuzzleDone of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 250])
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(= seconds (= seconds 2))
			)
			(1
				(Message msgGET 341 1 0 0 6 @temp0)
				(= register
					(= register
						(Display
							@temp0
							dsCOORD
							20
							85
							dsCOLOR
							gInnerBordColor
							dsFONT
							300
							dsSAVEPIXELS
						)
					)
				)
				(= seconds (= seconds 7))
			)
			(2
				(Display {} dsRESTOREPIXELS register)
				(= cycles (= cycles 1))
			)
			(3
				(proc0_2)
				(global2 newRoom: 200)
			)
		)
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
				(EcoNarrator init: 1 0 0 3 self)
			)
			(2
				(if (== (gEgo edgeHit?) 4)
					(gEgo
						setMotion: MoveTo (+ (gEgo x?) 40) (gEgo y?) self
					)
				else
					(gEgo
						setMotion: MoveTo (- (gEgo x?) 40) (gEgo y?) self
					)
				)
			)
			(3 (proc0_2) (self dispose:))
		)
	)
)

(instance manatee of EcoActor
	(properties
		x 145
		y 220
		yStep 4
		view 231
		signal $6000
		xStep 5
	)
)

(instance pump of EcoActor
	(properties
		x 154
		y -10
		yStep 3
		view 343
		priority 14
		signal $6010
	)
)

(instance bottle of EcoActor
	(properties
		x 225
		y 80
		yStep 4
		view 343
		loop 1
		signal $4000
		cycleSpeed 4
	)
)

(instance sandwich of EcoActor
	(properties
		x 286
		y -50
		view 343
		loop 2
		signal $2000
		cycleSpeed 5
	)
)

(instance Gregarious of EcoTalker
	(properties
		nsTop 5
		nsLeft 5
		view 240
		charNum 7
		keepWindow 1
	)
	
	(method (init)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of EcoProp
	(properties
		view 240
	)
)

(instance gEyes of EcoProp
	(properties
		nsTop 13
		nsLeft 13
		view 240
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of EcoProp
	(properties
		nsTop 16
		nsLeft 9
		view 240
		loop 1
		cycleSpeed 10
	)
)
