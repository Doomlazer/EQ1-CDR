;;; Sierra Script 1.0 - (do not remove this comment)
(script# 440)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PFollow)
(use PolyPath)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm440 0
)

(local
	local0
	local1
	local2
)
(instance rm440 of EcoRoom
	(properties
		picture 440
		horizon 5
		east 480
		west 420
		picAngle 15
	)
	
	(method (init)
		(= global250 3)
		(= global251 1)
		(self setRegions: 51)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 109 0 88 65 96 85 83 108 93 91 128 64 126 57 109
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						146
						165
						169
						120
						220
						115
						244
						135
						265
						146
						319
						111
						330
						230
						-20
						230
						-20
						148
						54
						155
						85
						172
						102
						185
						149
						185
						309
						184
						291
						171
						235
						172
						154
						178
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 104 124 106 108 112 107 114 94 122 95 123 112 136 111 136 121
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 177 102 187 91 196 102 206 102 186 111 166 103
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						186
						57
						313
						13
						313
						5
						138
						5
						138
						40
						92
						42
						92
						-40
						45
						-40
						45
						35
						-10
						35
						-10
						-45
						330
						-45
						330
						50
						272
						68
						194
						68
					yourself:
				)
		)
		(gFeatures
			add:
				CoveCave
				BrainCoral
				StaghornCoral1
				StaghornCoral2
				StaghornCoral3
				CrownOfThornsStarfish
				SeaUrchins
				LoneUrchin
				SeaFan
				SeaPlume
				Anemones1
				Anemones2
				SkinnyStarFish
				FatStarFish
				RedbeardSponge
				CommonSponge
				LettuceCoral
				TreeCoral
				OceanFloor
			eachElementDo: #init
		)
		(bigAnemoneTop init:)
		(if (and (not (proc819_5 19)) (== global124 440))
			(proc819_3 21)
			(bigAnemoneBottom init:)
			(anemBubbles init:)
		)
		(ghostAnemone init:)
		(blackSeaweed init:)
		(tubeSponge init:)
		(gEgo init:)
		(proc819_6)
		(gEgo ignoreHorizon: illegalBits: 0)
		(if (not (proc819_5 73))
			(gDelph
				x: -80
				y: -20
				view: 831
				ignoreActors: 0
				ignoreHorizon: 1
				moveSpeed: 0
				cycleSpeed: 0
				init:
			)
			(proc819_7)
			(gDelph z: 50 setPri: 15 setMotion: PFollow gEgo 90)
		)
		(fallingKey
			view: 442
			setLoop: 5
			x: 77
			y: 5
			xStep: 3
			yStep: 3
			cycleSpeed: 12
			init:
			setPri: 0
			stopUpd:
			hide:
		)
		(if (proc819_5 19)
			(fallingKey posn: 106 87 setPri: 0 show: stopUpd:)
			(redFish
				posn: 47 85
				ignoreActors: 1
				setLoop: 5
				xStep: 7
				yStep: 3
				moveSpeed: 1
				init:
				setCycle: Fwd
				setMotion: PolyPath 50 85
			)
		)
		(if (proc819_5 22)
			(fallingKey posn: 126 180 setPri: 11 show: stopUpd:)
		)
		(if (!= global124 440) (clownFish init:))
		(if (< (fish3 detailLevel:) (gGame detailLevel:))
			(fish3 init:)
		)
		(if (< (fish4 detailLevel:) (gGame detailLevel:))
			(fish4 init:)
		)
		(if (< (fish5 detailLevel:) (gGame detailLevel:))
			(fish5 init:)
		)
		(if (< (fish7 detailLevel:) (gGame detailLevel:))
			(fish7 init:)
		)
		(switch gSouth
			(420
				(= style (= style -32759))
				(if (proc819_5 19)
					(fallingKey posn: 106 87 show: stopUpd:)
				)
				(gEgo
					posn: 1 82
					heading: 90
					setMotion: PolyPath 14 88 self
				)
				(if (not (proc819_5 73))
					(gDelph posn: -100 62 setMotion: PFollow gEgo 90)
				)
			)
			(460
				(= style (= style 6))
				(gEgo posn: 55 0)
				(cond 
					((proc819_5 18) (self setScript: fromCoveNormal))
					((proc819_5 19) (self setScript: fromCoveAfterKey))
					(else (self setScript: fromCoveNormal))
				)
			)
			(480
				(= style (= style 11))
				(if (not (proc819_5 73)) (gDelph posn: 420 62))
				(if (and (not (proc819_5 19)) (== global124 440))
					(gEgo x: 295)
					(ghostAnemone setScript: followedRedFishTalk)
				)
			)
			(else 
				(= style (= style 7))
				(gEgo posn: 150 100)
				(if (not (proc819_5 73)) (gDelph posn: -40 30))
			)
		)
		(super init:)
		(if (!= (gLongSong number?) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(gLongSong2 number: 443 loop: -1 flags: 1 play:)
	)
	
	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 33 42 7)
		(Palette palANIMATE 33 42 7)
		(cond 
			(script 0)
			((& (gEgo onControl: 1) $0002) (self setScript: toCove))
		)
	)
	
	(method (dispose)
		(if (gCast contains: gDelph)
			(gDelph setMotion: 0 dispose:)
		)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 6 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (proc999_5 newRoomNumber west 460)
			(gLongSong fade:)
			(gLongSong2 flags: 0)
		)
		(gLongSong2 fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance redFish of EcoActor
	(properties
		yStep 7
		view 443
		loop 1
		cycleSpeed 8
		xStep 11
	)
	
	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setCycle: Fwd)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(44
				(if
					(and
						(== temp0 29)
						(not (proc819_5 19))
						(not (proc819_5 18))
					)
					(EcoNarrator init: 3 0 0 30)
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

(instance fallingKey of EcoActor
	(properties
		approachX 146
		approachY 95
		signal $6000
		illegalBits $0000
	)
	
	(method (init)
		(super init: &rest)
		(self approachVerbs: 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if (proc819_5 19)
						(proc819_4 19)
						(fallingKey setScript: chaseFish)
					)
					(if (proc819_5 22)
						(fallingKey setScript: egoGetsKey)
						(proc0_4 2 310)
					)
				)
			)
			(1
				(if (proc819_5 91)
					((ScriptID 2 1) init: 1 0 0 11 1)
				else
					(EcoNarrator init: 3 0 0 10)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fish3 of EcoActor
	(properties
		x 155
		y 75
		view 54
		cycleSpeed 10
		illegalBits $0000
		xStep 1
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			detailLevel: 3
			setLoop: 1
			setCycle: Fwd
			setPri: 9
			setHeading: 250
			setMotion: MoveTo -85 100 self
		)
	)
	
	(method (doit)
		(if (< (self x?) -75) (self x: 435 y: 50))
		(super doit: &rest)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 1 0 0 (Random 1 8) 0 50)
				)
			)
			(44
				(switch temp0
					(29
						(EcoNarrator init: 1 0 0 (Random 9 12) 0 50)
					)
					(17
						(EcoNarrator init: 1 0 0 (Random 13 16) 0 50)
					)
					(30
						(EcoNarrator init: 1 0 0 (Random 17 20) 0 50)
					)
					(37
						(EcoNarrator init: 1 0 0 (Random 20 24) 0 50)
					)
					(12
						(EcoNarrator init: 1 0 0 (Random 25 28) 0 50)
					)
					(36
						(EcoNarrator init: 1 0 0 (Random 29 32) 0 50)
					)
					(else 
						(EcoNarrator init: 1 0 0 (Random 37 41) 0 50)
					)
				)
			)
			(6
				(EcoNarrator init: 1 0 0 (Random 33 36) 0 50)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 1 0 0 (+ 70 (Random 0 2)) 0 50)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fish4 of EcoActor
	(properties
		x 180
		y 6
		view 56
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			detailLevel: 3
			setLoop: 2
			setCycle: Fwd
			setPri: 2
			xStep: 3
			cycleSpeed: 22
			setHeading: 250
			setMotion: MoveTo 725 25 self
		)
	)
	
	(method (doit)
		(if (> (self x?) 720) (self x: -125 y: 4))
		(super doit: &rest)
	)
	
	(method (doVerb)
		(fish3 doVerb: &rest)
	)
)

(instance fish5 of EcoActor
	(properties
		x 245
		y 90
		view 59
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			detailLevel: 2
			setLoop: 3
			setCycle: Fwd
			setPri: 0
			xStep: 1
			cycleSpeed: 12
			setHeading: 100
			setMotion: MoveTo -65 85 self
		)
	)
	
	(method (doit)
		(if (< (self x?) -55) (self x: 475 y: 78))
		(super doit: &rest)
	)
	
	(method (doVerb)
		(fish3 doVerb: &rest)
	)
)

(instance fish7 of EcoActor
	(properties
		x -125
		y 175
		view 55
		loop 3
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			detailLevel: 1
			setLoop: 3
			setCycle: Fwd
			cycleSpeed: 4
			xStep: 4
			setHeading: 250
			setMotion: MoveTo 800 80 self
		)
	)
	
	(method (doVerb)
		(fish3 doVerb: &rest)
	)
	
	(method (cue)
		(if (> (self x?) 790)
			(self
				posn: 500 100
				setLoop: 2
				setMotion: MoveTo -400 140 self
			)
		)
		(if (< (self x?) -350)
			(self
				posn: -325 150
				setLoop: 3
				setMotion: MoveTo 800 110 self
			)
		)
		(super doit: &rest)
	)
)

(instance clownFish of EcoActor
	(properties
		x 38
		y 161
		z 15
		approachX 110
		approachY 160
		view 72
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			setPri: 15
			detailLevel: 1
			setCycle: Fwd
			cycleSpeed: 10
			moveSpeed: 9
			setStep: 1 1
			setLoop: 0
			setMotion: MoveTo 50 161 self
		)
		(self approachVerbs: 4 1 9 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 1) init: 1 0 0 7 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: clownTalk)
				)
			)
			(2
				((ScriptID 2 1) init: 1 0 0 8 1)
			)
			(44
				(if (proc999_5 temp0 20 8 28)
					(EcoNarrator init: 3 0 0 45)
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(6 (EcoNarrator init: 3 0 0 46))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
	
	(method (cue)
		(cond 
			((> (clownFish x?) 43) (self setMotion: MoveTo 41 151 self))
			((< (clownFish y?) 153) (self setMotion: MoveTo 35 167 self))
			((> (clownFish y?) 165) (self setMotion: MoveTo 30 163 self))
			((< (clownFish x?) 32) (self setMotion: MoveTo 47 156 self))
		)
		(super cue: &rest)
	)
)

(instance burper of EcoProp
	(properties
		x 50
		y 136
		view 442
		loop 7
		cycleSpeed 18
	)
)

(instance bigAnemoneTop of EcoProp
	(properties
		x 41
		y 143
		approachX 110
		approachY 160
		view 442
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			detailLevel: 1
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 23
		)
		(self approachVerbs: 4 1 9 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(bigAnemoneBottom doVerb: theVerb temp0 &rest)
	)
)

(instance bigAnemoneBottom of EcoProp
	(properties
		x 21
		y 161
		approachX 110
		approachY 160
		view 442
		loop 6
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			detailLevel: 3
			setPri: 15
			setCel: 3
			setCycle: Fwd
			cycleSpeed: 23
		)
		(self approachVerbs: 4 1 9 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 77 79) 0 4))
					((proc819_5 21) (EcoNarrator init: 3 0 0 19))
					((proc819_5 91) ((ScriptID 2 0) init: 2 0 0 42 1))
					(else
						(if local1
							((ScriptID 2 0) init: 2 0 0 9 1)
						else
							((ScriptID 2 0) init: 2 0 0 10 1)
						)
						(= local1 (^ local1 $0001))
					)
				)
			)
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((proc819_5 91) ((ScriptID 2 0) init: 2 0 0 41 1))
					((not (proc819_5 21)) (rm440 setScript: preBulgeAnemLookTalk))
					(else (EcoNarrator init: 3 0 0 18))
				)
			)
			(44
				(switch temp0
					(36
						(if (proc819_5 21)
							(bigAnemoneBottom setScript: dangleHeavePuke)
							(proc0_4 10 309)
						else
							(EcoNarrator init: 3 0 0 33)
						)
					)
					(29
						(EcoNarrator init: 3 0 0 12)
					)
					(37
						(if (proc819_5 21)
							(EcoNarrator init: 3 0 0 40)
						else
							(EcoNarrator init: 3 0 0 41)
						)
					)
					(17
						(if (proc819_5 21)
							(EcoNarrator init: 3 0 0 43)
						else
							(EcoNarrator init: 3 0 0 42)
						)
					)
					(12
						(if (proc819_5 21)
							(EcoNarrator init: 3 0 0 52)
						else
							(super doVerb: theVerb temp0 &rest)
						)
					)
					(else 
						(cond 
							((proc819_5 21) (EcoNarrator init: 3 0 0 35))
							((proc819_5 91) (EcoNarrator init: 3 0 0 23))
							(else (EcoNarrator init: 3 0 0 34))
						)
					)
				)
			)
			(2
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((proc819_5 21) (self setScript: burpAnim))
					((proc819_5 91) (EcoNarrator init: 3 0 0 32))
					(else ((ScriptID 2 0) init: 2 0 0 18 1))
				)
			)
			(6
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((proc819_5 21) (EcoNarrator init: 3 0 0 20))
					(else (EcoNarrator init: 3 0 0 38))
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance anemBubbles of EcoProp
	(properties
		x 40
		y 130
		approachX 110
		approachY 160
		view 807
	)
	
	(method (init)
		(super init: &rest)
		(self
			setLoop: 1
			ignoreActors: 1
			detailLevel: 0
			setPri: 15
			setCycle: Fwd
			cycleSpeed: 23
			setScript: handleAnemBubbles
		)
	)
)

(instance swingingLure of EcoProp
	(properties
		view 441
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			setPri: 13
			setCycle: Fwd
			cycleSpeed: 16
		)
	)
)

(instance ghostAnemone of EcoProp
	(properties
		x 300
		y 107
		approachX 220
		approachY 95
		view 440
		loop 1
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			detailLevel: 2
			setPri: 13
			setCycle: Fwd
			cycleSpeed: 16
		)
		(self approachVerbs: 4 1 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local1
						((ScriptID 2 0) init: 2 0 0 9 1)
					else
						((ScriptID 2 0) init: 2 0 0 10 1)
					)
					(= local1 (^ local1 $0001))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 27 1)
				)
			)
			(2
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 18 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance blackSeaweed of EcoProp
	(properties
		x 160
		y 171
		approachX 160
		approachY 95
		view 440
		lookStr 47
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			detailLevel: 3
			setCycle: Fwd
			cycleSpeed: 21
		)
		(self approachVerbs: 4 1 9 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4 (EcoNarrator init: 3 0 0 48))
			(6 (EcoNarrator init: 3 0 0 49))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance tubeSponge of EcoProp
	(properties
		x 34
		y 91
		approachX 120
		approachY 95
		view 440
		loop 2
	)
	
	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			detailLevel: 3
			setCycle: Fwd
			cycleSpeed: 28
		)
		(self approachVerbs: 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(rm440 setScript: commonSpongeDoTalk)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 29 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fishSkeleton of EcoProp
	(properties
		x 135
		y 160
		approachX 120
		approachY 140
		view 900
		loop 2
		cel 7
	)
	
	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setPri: 7 cycleSpeed: 28)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 12 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 13 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance CoveCave of EcoFeature
	(properties
		x 70
		y 27
		nsTop 13
		nsLeft 20
		nsBottom 35
		nsRight 110
		onMeCheck $0002
		approachX 130
		approachY 80
	)
	
	(method (init)
		(self approachVerbs: 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(global2 setScript: toCove)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 9)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Anemones1 of EcoFeature
	(properties
		x 24
		y 141
		nsTop 130
		nsBottom 190
		nsRight 60
		approachX 110
		approachY 160
	)
	
	(method (init)
		(self approachVerbs: 4 1 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 77 79) 0 4))
					((proc819_5 91) (EcoNarrator init: 3 0 0 29))
					((not (proc819_5 21))
						(if local1
							((ScriptID 2 0) init: 2 0 0 9 1)
						else
							((ScriptID 2 0) init: 2 0 0 10 1)
						)
						(= local1 (^ local1 $0001))
					)
					(else (EcoNarrator init: 3 0 0 27))
				)
			)
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((proc819_5 91) (EcoNarrator init: 3 0 0 28))
					((not (proc819_5 21)) (EcoNarrator init: 3 0 0 16))
					(else (EcoNarrator init: 3 0 0 26))
				)
			)
			(2
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((or (proc819_5 21) (proc819_5 91)) (EcoNarrator init: 3 0 0 31))
					(else ((ScriptID 2 0) init: 2 0 0 18 1))
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Anemones2 of EcoFeature
	(properties
		x 87
		y 165
		nsTop 160
		nsLeft 72
		nsBottom 190
		nsRight 106
		approachX 110
		approachY 160
	)
	
	(method (init)
		(self approachVerbs: 4 1 2)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(Anemones1 doVerb: theVerb temp0 &rest)
	)
)

(instance BrainCoral of EcoFeature
	(properties
		x 210
		y 129
		nsTop 115
		nsLeft 179
		nsBottom 143
		nsRight 241
		approachX 210
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1)
					)
					(= local0 (^ local0 $0001))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: brainCoralTalk)
				)
			)
			(2
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance StaghornCoral1 of EcoFeature
	(properties
		x 11
		y 39
		nsTop 18
		nsLeft 3
		nsBottom 61
		nsRight 20
		approachX 120
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1)
					)
					(= local0 (^ local0 $0001))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: staghornTalk)
				)
			)
			(2
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance StaghornCoral2 of EcoFeature
	(properties
		x 107
		y 64
		nsTop 46
		nsLeft 90
		nsBottom 82
		nsRight 125
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1)
					)
					(= local0 (^ local0 $0001))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: staghornTalk)
				)
			)
			(2
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance StaghornCoral3 of EcoFeature
	(properties
		x 153
		y 32
		nsTop 1
		nsLeft 123
		nsBottom 64
		nsRight 184
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1)
					)
					(= local0 (^ local0 $0001))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: staghornTalk)
				)
			)
			(2
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance CrownOfThornsStarfish of EcoFeature
	(properties
		x 281
		y 130
		nsTop 121
		nsLeft 269
		nsBottom 140
		nsRight 291
		approachX 220
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 38 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 5)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SeaUrchins of EcoFeature
	(properties
		x 23
		y 90
		nsTop 86
		nsLeft 12
		nsBottom 95
		nsRight 34
		approachX 120
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 3 0 0 50)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 2)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance LoneUrchin of EcoFeature
	(properties
		x 187
		y 181
		nsTop 174
		nsLeft 177
		nsBottom 189
		nsRight 198
		approachX 110
		approachY 160
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 3 0 0 50)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm440 setScript: loneUrchinTalk)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SeaFan of EcoFeature
	(properties
		x 241
		y 25
		nsTop 14
		nsLeft 228
		nsBottom 36
		nsRight 254
		approachX 220
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1)
					)
					(= local0 (^ local0 $0001))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 26 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SeaPlume of EcoFeature
	(properties
		x 117
		y 109
		nsTop 97
		nsLeft 108
		nsBottom 121
		nsRight 126
		approachX 160
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 3 0 0 51)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 47 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SkinnyStarFish of EcoFeature
	(properties
		x 59
		y 117
		nsTop 111
		nsLeft 53
		nsBottom 124
		nsRight 66
		approachX 120
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 3 0 0 24)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 8)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance FatStarFish of EcoFeature
	(properties
		x 220
		y 167
		nsTop 156
		nsLeft 212
		nsBottom 178
		nsRight 227
		approachX 110
		approachY 160
	)
	
	(method (init)
		(self approachVerbs: 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 3 0 0 24)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 32 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance RedbeardSponge of EcoFeature
	(properties
		x 300
		y 173
		nsTop 159
		nsLeft 292
		nsBottom 188
		nsRight 319
		approachX 110
		approachY 160
	)
	
	(method (init)
		(self approachVerbs: 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(rm440 setScript: commonSpongeDoTalk)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 3)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance CommonSponge of EcoFeature
	(properties
		x 193
		y 91
		nsTop 81
		nsLeft 178
		nsBottom 101
		nsRight 207
		approachX 160
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(rm440 setScript: commonSpongeDoTalk)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 20 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance LettuceCoral of EcoFeature
	(properties
		x 311
		y 115
		nsTop 105
		nsLeft 304
		nsBottom 125
		nsRight 319
		approachX 220
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1)
					)
					(= local0 (^ local0 $0001))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 25 1)
				)
			)
			(2
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance TreeCoral of EcoFeature
	(properties
		x 300
		y 60
		nsTop 45
		nsLeft 281
		nsBottom 75
		nsRight 319
		approachX 220
		approachY 95
	)
	
	(method (init)
		(self approachVerbs: 4 1)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(if local0
						(rm440 setScript: coralDoTalk2)
					else
						((ScriptID 2 0) init: 2 0 0 7 1)
					)
					(= local0 (^ local0 $0001))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 4)
				)
			)
			(2
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 34 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance OceanFloor of EcoFeature
	(properties
		onMeCheck $0004
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator init: 3 0 0 11)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fromCoveNormal of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setPri: 0 posn: 72 -34 forceUpd:)
				(= ticks (= ticks 60))
			)
			(1
				(gEgo setMotion: PolyPath 78 50 self)
			)
			(2
				(gEgo setPri: -1 setMotion: PolyPath 103 90 self)
			)
			(3 (self dispose:))
		)
	)
)

(instance fromCoveAfterKey of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setPri: 0 posn: 72 34 loop: 2 setHeading: 170)
				(if (proc819_5 44)
					(fallingKey
						posn: 77 5
						show:
						ignoreActors: 1
						view: 442
						loop: 5
						xStep: 5
						yStep: 7
						cycleSpeed: 18
						setCycle: Fwd
						setMotion: MoveTo 106 87 self
					)
				else
					(fallingKey posn: 106 87)
					(self cue:)
				)
				(proc819_4 44)
			)
			(1
				(fallingKey setPri: 0 stopUpd:)
				(gEgo setMotion: MoveTo 85 64 self)
			)
			(2
				(gEgo setPri: -1 setMotion: PolyPath 140 70 self)
			)
			(3 (gEgo setHeading: 305 self))
			(4 (self dispose:))
		)
	)
)

(instance toCove of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setMotion: PolyPath 70 20 self)
			)
			(1
				(gEgo setCycle: 0 setLoop: 3)
				(= ticks (= ticks 10))
			)
			(2
				(gEgo setCycle: Fwd setMotion: MoveTo 70 10 self)
			)
			(3
				(global2 newRoom: 460)
				(self dispose:)
			)
		)
	)
)

(instance chaseFish of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(redFish
					setLoop: 6
					cel: 0
					posn: 85 74
					setCycle: CT 1 1 self
				)
			)
			(1
				(gSoundEffects number: 442 loop: 1 play:)
				(fallingKey hide:)
				(redFish setLoop: 6 posn: 85 74 setCycle: End self)
			)
			(2
				(EcoNarrator posn: -1 130 init: 3 0 0 17 self)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 10 1)
				(redFish
					setLoop: 0
					posn: 118 100
					xStep: 11
					yStep: 7
					setCycle: Fwd
					setMotion: PolyPath 189 110 self
				)
				(gEgo setMotion: PolyPath 310 95)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 44 1 self)
			)
			(5
				((ScriptID 2 0) init: 2 0 0 46 1)
				(redFish
					setLoop: 2
					posn: 200 122
					setMotion: PolyPath 355 85 self
				)
				(proc819_4 19)
				(= global124 480)
			)
			(6
				(gEgo setMotion: PolyPath 330 95 self)
			)
			(7
				(global2 newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance delWanders of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gDelph setPri: 15)
				(if (> (gDelph x?) 320)
					(gDelph setMotion: MoveTo -20 20 self)
				)
				(if (< (gDelph x?) 0)
					(gDelph setMotion: MoveTo 340 20 self)
				)
			)
			(1
				(self dispose:)
				(global2 newRoom: 460)
			)
		)
	)
)

(instance dangleHeavePuke of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setMotion: PolyPath 54 109 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 441
					loop: 1
					posn: 54 109
					setCycle: Fwd
				)
				(swingingLure
					view: 441
					loop: 0
					init:
					posn: 45 108
					setCycle: Fwd
				)
				(= ticks (= ticks 60))
			)
			(2
				(EcoNarrator posn: -1 25 init: 3 0 0 21 self)
			)
			(3 (= ticks (= ticks 30)))
			(4
				(gEgo put: 27 0)
				(proc819_3 91)
				(bigAnemoneTop
					view: 442
					loop: 1
					cel: 0
					posn: 41 143
					cycleSpeed: 23
					setCycle: CT 3 1 self
				)
				(bigAnemoneBottom
					view: 442
					loop: 6
					posn: 21 161
					setCycle: Beg
				)
			)
			(5
				(swingingLure dispose:)
				(gSoundEffects number: 441 loop: 1 play:)
				(bigAnemoneTop setCycle: CT 5 1 self)
			)
			(6
				(bigAnemoneTop setCel: 6)
				(fallingKey
					view: 442
					loop: 2
					setCel: 0
					setPri: 15
					posn: 105 139
					show:
				)
				(= cycles (= cycles 7))
			)
			(7
				(bigAnemoneTop
					view: 442
					loop: 0
					cel: 0
					x: 41
					y: 143
					cycleSpeed: 23
					setCycle: Fwd
				)
				(fallingKey
					view: 442
					loop: 2
					posn: 105 139
					cycleSpeed: 23
					setCycle: End self
				)
			)
			(8
				(fallingKey
					view: 442
					loop: 5
					posn: 117 146
					setCycle: Fwd
					setMotion: MoveTo 129 172 self
				)
			)
			(9
				((ScriptID 2 0) init: 2 0 0 13 1 self)
			)
			(10
				(fallingKey
					setCel: 0
					posn: 129 172
					setPri: 0
					approachX: 110
					approachY: 170
					stopUpd:
				)
				(proc819_6)
				(= global124 0)
				(proc819_4 21)
				(proc819_3 22)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsKey of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gEgo setMotion: PolyPath 123 158 self)
			)
			(1
				(EcoNarrator init: 3 0 0 14 self)
			)
			(2
				(gEgo get: 24)
				(fallingKey hide: dispose:)
				(proc819_4 22)
				(self dispose:)
			)
		)
	)
)

(instance handleAnemBubbles of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(anemBubbles cel: 0 setCycle: End self)
			)
			(1 (= ticks (= ticks 720)))
			(2
				(= state (= state -1))
				(self cue:)
			)
			(3 (self dispose:))
		)
	)
)

(instance clownTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 14 1 self)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 5 1 self)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 15 1 self)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 3 1 self)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 16 1 self)
			)
			(5
				((ScriptID 2 1) init: 1 0 0 4 1 self)
			)
			(6
				((ScriptID 2 0) init: 2 0 0 17 1 self)
			)
			(7 (self dispose:))
		)
	)
)

(instance commonSpongeTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 20 1 self)
			)
			(1 (self dispose:))
		)
	)
)

(instance commonSpongeDoTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 39 1 self)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 6 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance staghornTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 21 0 self)
			)
			(1
				((ScriptID 2 0) init: 2 0 0 22 0 self)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 23 0 self)
			)
			(3
				((ScriptID 2 0) init: 2 0 0 24 1 self)
			)
			(4 (self dispose:))
		)
	)
)

(instance brainCoralTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 28 0 self)
			)
			(1
				((ScriptID 2 0) init: 2 0 0 33 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance loneUrchinTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 30 0 self)
			)
			(1
				((ScriptID 2 0) init: 2 0 0 31 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance preBulgeAnemLookTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 2 0 self)
			)
			(1
				((ScriptID 2 0) init: 2 0 0 4 0 self)
			)
			(2
				((ScriptID 2 1) init: 1 0 0 2 1 self)
			)
			(3
				((ScriptID 2 0) init: 2 0 0 5 1 self)
			)
			(4 (self dispose:))
		)
	)
)

(instance bulgeAnemTalkT of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 3 1 self)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 4 1 self)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 5 1 self)
			)
			(3 (self dispose:))
		)
	)
)

(instance coralDoTalk2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				((ScriptID 2 0) init: 2 0 0 8 0 self)
			)
			(1
				((ScriptID 2 0) init: 2 0 0 37 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance followedRedFishTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(= ticks (= ticks 300))
			)
			(1
				(gEgo setMotion: PolyPath 200 85 self)
			)
			(2
				(gEgo setHeading: 270)
				(= ticks (= ticks 100))
			)
			(3
				((ScriptID 2 1) init: 1 0 0 9 1 self)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 45 1 self)
			)
			(5
				(self setScript: burpAnim self)
			)
			(6
				(proc0_2)
				(= ticks (= ticks 4200))
			)
			(7
				(if (not (proc819_5 91))
					((ScriptID 2 0) init: 2 0 0 40 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance burpAnim of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(gSoundEffects number: 441 loop: 1 play:)
				(burper init: setCycle: End self)
			)
			(1
				(burper dispose:)
				(self dispose:)
			)
		)
	)
)
