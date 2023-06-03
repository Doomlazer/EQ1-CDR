;;; Sierra Script 1.0 - (do not remove this comment)
(script# 480)
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
(use n958)
(use DPath)
(use Cycle)
(use InvI)
(use Obj)

(public
	rm480 0
)

(local
	local0
	local1
	local2 =  1
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)
(instance rm480 of EcoRoom
	(properties
		picture 480
		horizon 20
		north 343
		east 500
		west 440
		walkOffTop 1
	)
	
	(method (init)
		(= global251 1)
		(proc958_0 128 481 482)
		(gFeatures
			add:
				OceanFloor
				EastSide
				OctopusLair
				DeadBrainCoral
				PillarCoral
				StaghornCoral
				TreeCoral
				LettuceCoral1
				LettuceCoral2
				StarletCoral
				RedbeardSponge1
				RedbeardSponge2
				RedSponge
			eachElementDo: #init
		)
		(if (not (proc819_5 313)) (SteelCable init:))
		(if (== ((Inv at: 32) owner?) 480)
			(Jar init: setCel: 1)
			(= global233 1)
		)
		(frond0 init:)
		(proc819_6)
		(gEgo init: setLoop: gStopGroop ignoreHorizon: 1)
		(if (not (proc819_5 73))
			(proc819_7)
			(gDelph z: 50 init:)
		)
		(switch gSouth
			(440
				(if (not (proc819_5 73))
					(gDelph
						posn: -60 (gEgo y?)
						heading: 90
						setMotion: DPath 60 30 140 60 self
					)
				)
				(if (== global124 gNumber)
					(redFish
						posn: 180 85
						loop: 0
						cycleSpeed: 4
						init:
						setCycle: Fwd
						setMotion: PolyPath 340 84
					)
				)
			)
			(500
				(if (not (proc819_5 73))
					(gDelph posn: 380 -80 setMotion: DPath 60 30 140 60 self)
				)
				(if (== global124 gNumber)
					(redFish
						posn: 150 85
						loop: 1
						cycleSpeed: 4
						init:
						setCycle: Fwd
						setMotion: PolyPath -50 84
					)
				)
			)
			(343
				(self setScript: enterFromDriftnet2)
				(if (not (proc819_5 73))
					(gDelph
						posn: (gEgo x?) -80
						heading: 180
						setMotion: PFollow gEgo 90
					)
				)
			)
			(345
				(self setScript: enterFromDriftnet2)
			)
			(else 
				(if (not (proc819_5 73))
					(gDelph
						posn: (gEgo x?) -95
						heading: 180
						setMotion: PFollow gEgo 90
					)
				)
			)
		)
		(if (proc819_5 139) (= local3 1))
		(if (proc819_5 101) (= local5 1))
		(proc819_4 101)
		(if (or (gEgo has: 31) (proc819_5 334))
			(octopus view: 482 loop: 0 x: 151 y: 72 init:)
			(= local3 1)
			(= local1 1)
			(= local2 0)
		else
			(octopus view: 480 loop: 3 cel: 1 x: 145 y: 99 init:)
			(= local2 1)
		)
		(if
		(and (not (proc819_5 67)) (not (proc819_5 73)))
			(helpBubbles init:)
		)
		(if (< (fish1 detailLevel:) (gGame detailLevel:))
			(fish1 init:)
		)
		(if (< (fish2 detailLevel:) (gGame detailLevel:))
			(fish2 init:)
		)
		(if (< (fish3 detailLevel:) (gGame detailLevel:))
			(fish3 init:)
		)
		(if (< (fish5 detailLevel:) (gGame detailLevel:))
			(fish5 init:)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 168 7 155 48 45 50 0 52 0 0 169 0
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 114 45 126 70 151 92 175 288 175 310 165 319 165 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 175 125 221 132 229 152 157 152 161 129
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 302 121 204 121 202 99 302 99
					yourself:
				)
		)
		(switch gSouth
			(345
				(= style (= style (= style (= style -32759))))
			)
			(440
				(= style (= style (= style (= style 12))))
			)
			(343
				(= style (= style (= style (= style -32759))))
			)
			(500
				(= style (= style (= style (= style 11))))
			)
			(else 
				(= style (= style (= style (= style 6))))
			)
		)
		(self setRegions: 51)
		(super init: &rest)
		(if (proc819_5 73)
			(= north (= north (= north (= north 345))))
		)
		(if (or (== gSouth 440) (== gSouth 500))
			(self setScript: followingFish)
		)
		(if (!= (gLongSong number?) 440)
			(gLongSong number: 440 loop: -1 play:)
		)
		(gLongSong2 number: 444 loop: -1 flags: 1 play:)
	)
	
	(method (doit)
		(super doit: &rest)
		(if (> global87 0) (Palette palANIMATE 33 42 7))
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
					(EcoNarrator init: 3 0 0 14)
				)
			)
			(6 (EcoNarrator init: 3 0 0 38))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance octopus of EcoActor
	(properties
		approachX 140
		approachY 128
		view 482
		loop 9
		xStep 5
	)
	
	(method (init)
		(self ignoreActors: 1 setPri: 1 setCel: 1 cycleSpeed: 26)
		(super init: &rest)
		(self approachVerbs: 1 2)
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
					((not (proc819_5 139)) (EcoNarrator posn: -1 20 init: 3 0 0 60))
					(local1 ((ScriptID 2 0) init: 2 0 0 7 1))
					(else (EcoNarrator posn: -1 20 init: 3 0 0 34))
				)
			)
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((not (proc819_5 139)) (EcoNarrator posn: -1 20 init: 3 0 0 59))
					(local1 (self setScript: octLookTalk))
					((not (proc819_5 136)) (EcoNarrator posn: -1 20 init: 3 0 0 76))
					(else (EcoNarrator posn: -1 20 init: 3 0 0 63))
				)
			)
			(44
				(switch temp0
					(32
						(if local1
							(EcoNarrator init: 3 0 0 47)
						else
							(gEgo setScript: mirrorCartoon)
						)
					)
					(41
						(if
						(and (== global233 0) (== local7 0) (== local4 0))
							(gEgo setScript: egoPlaceJar)
						else
							(EcoNarrator posn: -1 20 init: 3 0 0 45)
						)
					)
					(29
						(if (proc819_5 139)
							(EcoNarrator init: 3 0 0 39)
						else
							(EcoNarrator posn: -1 20 init: 3 0 0 61)
						)
					)
					(30
						(if (proc819_5 139)
							(EcoNarrator init: 3 0 0 56)
						else
							(EcoNarrator posn: -1 20 init: 3 0 0 61)
						)
					)
					(36
						(if (proc819_5 139)
							(EcoNarrator init: 3 0 0 68)
						else
							(EcoNarrator posn: -1 20 init: 3 0 0 67)
						)
					)
					(else 
						(if (proc819_5 139)
							(EcoNarrator posn: -1 20 init: 3 0 0 82)
						else
							(EcoNarrator posn: -1 20 init: 3 0 0 61)
						)
					)
				)
			)
			(2
				(cond 
					((proc819_5 73) (EcoNarrator init: 3 0 0 4))
					(local1 ((ScriptID 2 0) init: 2 0 0 6 1))
					(local5 (EcoNarrator init: 3 0 0 4))
					((proc819_5 139) (EcoNarrator init: 3 0 0 4))
					(else ((ScriptID 2 0) init: 2 0 0 22 1))
				)
			)
			(6
				(if (or (proc819_5 139) (proc819_5 73))
					(EcoNarrator init: 3 0 0 71)
				else
					((ScriptID 2 0) init: 2 0 0 28 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance redFish of EcoActor
	(properties
		yStep 7
		view 443
		signal $6000
		xStep 11
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(4
				((ScriptID 2 1) init: 2 0 0 1 1 0 50)
			)
			(6
				(EcoNarrator init: 1 0 0 79 0 50)
			)
			(44
				(switch temp0
					(36
						(EcoNarrator init: 1 0 0 75 0 50)
					)
					(29
						(EcoNarrator init: 1 0 0 74 0 50)
					)
					(37
						(EcoNarrator init: 1 0 0 76 0 50)
					)
					(17
						(EcoNarrator init: 1 0 0 77 0 50)
					)
					(else 
						(EcoNarrator init: 1 0 0 78 0 50)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fish1 of EcoActor
	(properties
		x 245
		y 35
		view 50
		detailLevel 1
		illegalBits $0000
		xStep 4
	)
	
	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setLoop: 3
			setCycle: Fwd
			cycleSpeed: 16
			setHeading: 100
			setMotion: PolyPath 475 60 self
		)
		(super init: &rest)
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
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(self x: -250 y: 10 setMotion: PolyPath 475 60 self)
		(super cue: &rest)
	)
)

(instance fish2 of EcoActor
	(properties
		x -45
		y 35
		view 51
		detailLevel 1
		illegalBits $0000
		xStep 2
	)
	
	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setLoop: 2
			setCycle: Fwd
			cycleSpeed: 12
			setHeading: 100
			setMotion: PolyPath 475 40 self
		)
		(super init: &rest)
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
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(self x: -65 y: 50 setMotion: PolyPath 475 40 self)
		(super cue: &rest)
	)
)

(instance fish3 of EcoActor
	(properties
		x 45
		y 55
		view 53
		detailLevel 2
		illegalBits $0000
		xStep 8
	)
	
	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setCycle: Fwd
			cycleSpeed: 4
			setMotion: MoveTo 475 40 self
		)
		(super init: &rest)
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
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(if (> (self x?) 460)
			(self y: -10 setLoop: 1 setMotion: MoveTo -575 120 self)
		else
			(self y: -10 setLoop: 0 setMotion: MoveTo 495 170 self)
		)
		(super cue: &rest)
	)
)

(instance fish5 of EcoActor
	(properties
		x 245
		y 45
		view 80
		detailLevel 3
		illegalBits $0000
		xStep 4
	)
	
	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setLoop: 3
			setCycle: Fwd
			cycleSpeed: 26
			setHeading: 100
			setMotion: MoveTo 400 20 self
		)
		(super init: &rest)
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
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(if (> (self x?) 380)
			(self x: -365 y: 160 setMotion: MoveTo 400 20 fish5)
		)
		(super cue: &rest)
	)
)

(instance helpBubbles of EcoActor
	(properties
		x 300
		y -5
		view 341
		illegalBits $0000
		xStep 2
	)
	
	(method (init)
		(self
			ignoreActors: 1
			ignoreHorizon: 1
			setPri: 1
			setLoop: 5
			cycleSpeed: 26
			setScript: timedHelpBubbles
		)
		(super init: &rest)
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
					((ScriptID 2 0) init: 2 0 0 23 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance frond0 of EcoProp
	(properties
		approachX 140
		approachY 128
	)
	
	(method (init)
		(self
			view: 480
			loop: 0
			cel: 0
			x: 131
			y: 52
			setPri: 0
			detailLevel: 3
			ignoreActors: 1
			setCycle: Fwd
			cycleSpeed: 23
		)
		(super init: &rest)
		(self approachVerbs: 1)
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
					(EcoNarrator init: 3 0 0 19)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance frond1 of EcoProp
	(properties
		approachX 140
		approachY 128
	)
	
	(method (init)
		(self
			view: 480
			loop: 1
			cel: 0
			x: 62
			y: 40
			setPri: 0
			detailLevel: 3
			ignoreActors: 1
			setCycle: Fwd
			cycleSpeed: 33
		)
		(super init: &rest)
		(self approachVerbs: 1)
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
					(EcoNarrator init: 3 0 0 19)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance SteelCable of EcoView
	(properties
		approachX 140
		approachY 128
	)
	
	(method (init)
		(self
			view: 480
			loop: 2
			cel: 0
			x: 123
			y: 116
			setPri: 2
			ignoreActors: 1
		)
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
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 77 79) 0 4))
					((not (proc819_5 101)) (gEgo setScript: egoGrabbed))
					(else (gEgo setScript: egoGetsCable))
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(frond0 setScript: cableLookTalk)
				)
			)
			(6
				(EcoNarrator posn: -1 20 init: 3 0 0 84)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance Jar of EcoView
	(properties
		approachX 140
		approachY 128
	)
	
	(method (init)
		(self
			view: 482
			loop: 8
			cel: 0
			x: 170
			y: 130
			setPri: 2
			ignoreActors: 1
		)
		(super init: &rest)
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
					(gEgo setScript: egoPicksUpJar)
				)
			)
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((!= global233 1) (EcoNarrator posn: -1 20 init: 3 0 0 77))
					(else (EcoNarrator posn: -1 20 init: 3 0 0 79))
				)
			)
			(44
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((== global233 1) (EcoNarrator posn: -1 20 init: 3 0 0 85))
					(else (EcoNarrator posn: -1 20 init: 3 0 0 62))
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance OctopusLair of EcoFeature
	(properties
		x 146
		y 90
		nsTop 87
		nsLeft 91
		nsBottom 102
		nsRight 182
		approachX 140
		approachY 128
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
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 77 79) 0 4))
					((== local4 1)
						(if (proc819_5 313)
							(EcoNarrator posn: -1 20 init: 3 0 0 36)
						else
							(EcoNarrator init: 3 0 0 81)
						)
					)
					(local1 (EcoNarrator init: 3 0 0 36))
					(local5 (EcoNarrator init: 3 0 0 35))
					((proc819_5 139) (EcoNarrator init: 3 0 0 34))
					(else ((ScriptID 2 0) init: 2 0 0 4 1))
				)
			)
			(1
				(cond 
					((proc819_5 73) (EcoNarrator init: 2 0 0 (Random 74 76) 0 4))
					((== local4 1) (EcoNarrator init: 3 0 0 37))
					(local1 (EcoNarrator init: 3 0 0 31))
					(local5 (EcoNarrator init: 3 0 0 63))
					((proc819_5 139) (EcoNarrator init: 3 0 0 72))
					(else (rm480 setScript: lairTalk))
				)
			)
			(44
				(if local4
					(super doVerb: theVerb temp0 &rest)
				else
					(= theVerb 41)
					(octopus doVerb: theVerb)
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
		onMeCheck $4000
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
					(EcoNarrator posn: -1 20 init: 3 0 0 2)
				)
			)
			(44
				(switch temp0
					(41
						(if local4
							(EcoNarrator posn: -1 20 init: 3 0 0 45)
						else
							(= theVerb 41)
							(octopus doVerb: theVerb)
						)
					)
					(else 
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance EastSide of EcoFeature
	(properties
		x 295
		y 10
		nsLeft 270
		nsBottom 185
		nsRight 319
		approachX 140
		approachY 128
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
					(EcoNarrator init: 3 0 0 12)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance DeadBrainCoral of EcoFeature
	(properties
		x 291
		y 171
		nsTop 153
		nsLeft 265
		nsBottom 189
		nsRight 319
		approachX 240
		approachY 128
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
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator posn: -1 20 init: 3 0 0 5)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance PillarCoral of EcoFeature
	(properties
		x 245
		y 116
		nsTop 103
		nsLeft 221
		nsBottom 129
		nsRight 269
		approachX 140
		approachY 128
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
					((ScriptID 2 0) init: 2 0 0 16 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(rm480 setScript: pillarCoralTalk)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance StaghornCoral of EcoFeature
	(properties
		x 193
		y 147
		nsTop 135
		nsLeft 166
		nsBottom 160
		nsRight 219
		approachX 140
		approachY 128
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
					((ScriptID 2 0) init: 2 0 0 16 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator posn: -1 20 init: 3 0 0 9)
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
		x 32
		y 47
		nsTop 17
		nsLeft 15
		nsBottom 78
		nsRight 52
		approachX 140
		approachY 128
	)
	
	(method (init)
		(super init: &rest)
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
					((ScriptID 2 0) init: 2 0 0 16 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 6)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance LettuceCoral1 of EcoFeature
	(properties
		x 16
		y 114
		nsTop 100
		nsBottom 128
		nsRight 33
		approachX 140
		approachY 128
	)
	
	(method (init)
		(super init: &rest)
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
					((ScriptID 2 0) init: 2 0 0 16 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 11)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance LettuceCoral2 of EcoFeature
	(properties
		x 185
		y 58
		nsTop 48
		nsLeft 139
		nsBottom 68
		nsRight 231
		approachX 140
		approachY 128
	)
	
	(method (init)
		(super init: &rest)
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
					((ScriptID 2 0) init: 2 0 0 16 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 11)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance StarletCoral of EcoFeature
	(properties
		x 27
		y 140
		nsTop 134
		nsLeft 10
		nsBottom 147
		nsRight 44
		approachX 140
		approachY 128
	)
	
	(method (init)
		(super init: &rest)
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
					((ScriptID 2 0) init: 2 0 0 16 1)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					((ScriptID 2 0) init: 2 0 0 12 1)
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance RedbeardSponge1 of EcoFeature
	(properties
		x 34
		y 170
		nsTop 152
		nsBottom 188
		nsRight 68
		approachX 140
		approachY 128
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
			(1
				(EcoNarrator posn: -1 20 init: 3 0 0 10)
			)
			(4
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 77 79) 0 4)
				else
					(EcoNarrator posn: -1 20 init: 3 0 0 83)
				)
			)
			(44
				(if (== temp0 20)
					(EcoNarrator posn: -1 20 init: 3 0 0 74)
				else
					(EcoNarrator posn: -1 20 init: 3 0 0 73)
				)
			)
			(6
				(EcoNarrator posn: -1 20 init: 3 0 0 75)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance RedbeardSponge2 of EcoFeature
	(properties
		x 110
		y 142
		nsTop 119
		nsLeft 85
		nsBottom 164
		nsRight 135
		approachX 140
		approachY 128
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
					(frond0 setScript: egoHides)
				)
			)
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator posn: -1 20 init: 3 0 0 18)
				)
			)
			(44
				(if (== temp0 20)
					(EcoNarrator posn: -1 20 init: 3 0 0 74)
				else
					(EcoNarrator posn: -1 20 init: 3 0 0 73)
				)
			)
			(6
				(EcoNarrator posn: -1 20 init: 3 0 0 75)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance RedSponge of EcoFeature
	(properties
		x 106
		y 48
		nsTop 36
		nsLeft 92
		nsBottom 59
		nsRight 119
		approachX 140
		approachY 128
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
			(1
				(if (proc819_5 73)
					(EcoNarrator init: 2 0 0 (Random 74 76) 0 4)
				else
					(EcoNarrator init: 3 0 0 53)
				)
			)
			(44
				(if (== temp0 20)
					(EcoNarrator init: 3 0 0 74)
				else
					(EcoNarrator init: 3 0 0 73)
				)
			)
			(6 (EcoNarrator init: 3 0 0 75))
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance pillarCoralTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(EcoNarrator posn: -1 20 init: 3 0 0 7 self)
			)
			(1
				(EcoNarrator posn: -1 20 init: 3 0 0 8 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance fishGroupTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(if (not (proc819_5 73))
					((ScriptID 2 0) init: 2 0 0 9 0 self)
				else
					(self cue:)
				)
			)
			(1
				(if (not (proc819_5 73))
					((ScriptID 2 0) init: 2 0 0 10 0 self)
				else
					(self cue:)
				)
			)
			(2
				(if (not (proc819_5 73))
					((ScriptID 2 0) init: 2 0 0 11 1 self)
				else
					(self cue:)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance lairTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(EcoNarrator posn: -1 30 init: 3 0 0 3 self)
				(= local8 1)
			)
			(1
				(if (not (proc819_5 local4))
					((ScriptID 2 0) init: 2 0 0 4 1 self)
				else
					(= cycles (= cycles (= cycles (= cycles 1))))
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance octTalk1 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(EcoNarrator posn: -1 30 init: 3 0 0 44 self)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 4 1 self)
			)
			(2
				((ScriptID 2 0) init: 2 0 0 1 0 self)
			)
			(3
				((ScriptID 2 0) init: 2 0 0 14 0 self)
			)
			(4
				((ScriptID 2 0) init: 2 0 0 15 1 self)
			)
			(5
				((ScriptID 2 1) init: 1 0 0 2 1 self)
			)
			(6 (self dispose:))
		)
	)
)

(instance cableLookTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(EcoNarrator posn: -1 30 init: 3 0 0 20 self)
			)
			(1
				(EcoNarrator posn: -1 30 init: 3 0 0 13 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance octLookTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				((ScriptID 2 0) init: 2 0 0 5 0 self)
			)
			(1
				((ScriptID 2 0) init: 2 0 0 21 1 self)
			)
			(2 (self dispose:))
		)
	)
)

(instance enterFromDriftnet2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(gEgo
					ignoreHorizon: 1
					posn: 274 -20
					heading: 180
					cycleSpeed: 4
					setMotion: PolyPath 274 50 self
				)
			)
			(1 (proc0_2) (self dispose:))
		)
	)
)

(instance egoGrabbed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(proc819_3 139)
				(if local1
					(self setScript: octFromAboveToFront self)
				else
					(= cycles (= cycles (= cycles (= cycles 1))))
				)
			)
			(1
				(if (not (proc819_5 73))
					(gDelph setMotion: PolyPath 260 50)
				)
				(gEgo setMotion: PolyPath 186 102 self)
			)
			(2
				(proc0_1)
				(if local0
					(self setScript: octFromFrontToHide self)
				else
					(= cycles (= cycles (= cycles (= cycles 1))))
				)
			)
			(3
				(proc0_1)
				(if (not (proc819_5 73))
					(gDelph setMotion: PolyPath 250 50 self)
				else
					(= cycles (= cycles (= cycles (= cycles 1))))
				)
			)
			(4
				(gEgo setCycle: Walk setMotion: PolyPath 161 102 self)
			)
			(5
				(if (not (proc819_5 73))
					(gDelph setMotion: PolyPath 250 50)
				)
				(octopus setCel: 0)
				(gEgo setHeading: 270 self)
			)
			(6
				(octopus setCel: 1)
				(gEgo
					view: 481
					loop: 0
					x: 125
					y: 99
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(7
				(octopus setCel: 0)
				(= ticks (= ticks (= ticks (= ticks 140))))
			)
			(8
				(cond 
					((== local3 0) (rm480 setScript: octTalk1 self) (= local3 1))
					((proc819_5 136) (EcoNarrator posn: -1 30 init: 3 0 0 35 self))
					(else (EcoNarrator posn: -1 30 init: 3 0 0 22 self))
				)
			)
			(9 (gEgo setCycle: Beg self))
			(10
				(proc819_6)
				(gEgo setMotion: PolyPath 160 102 self)
			)
			(11
				(if (not (proc819_5 73))
					(gDelph setMotion: PFollow gEgo 90)
				)
				(octopus setCel: 1)
				(gEgo setHeading: 270)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsCable of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 186 102 self)
				(proc0_4 2 313)
			)
			(1
				(EcoNarrator posn: -1 20 init: 3 0 0 29 self)
			)
			(2
				(gEgo setCycle: Walk setMotion: PolyPath 156 102 self)
			)
			(3
				(gEgo get: 31)
				(proc0_4 2 313)
				(SteelCable hide:)
				((ScriptID 2 1) init: 1 0 0 1 1 self)
			)
			(4
				(proc819_6)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance mirrorCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(if (not (proc819_5 73))
					(gDelph setMotion: PolyPath 260 50)
				)
				(gEgo setMotion: PolyPath 173 90 self)
			)
			(1
				(proc0_4 10 312)
				(if local1
					(self setScript: octFromAboveToFront self)
				else
					(= ticks (= ticks (= ticks (= ticks 4))))
				)
			)
			(2
				(if (not (proc819_5 73))
					(gDelph setMotion: MoveTo 250 50 self)
				else
					(= ticks (= ticks (= ticks (= ticks 1))))
				)
			)
			(3
				(gEgo
					setCycle: 0
					view: 481
					loop: 4
					cel: 0
					x: 134
					y: 94
					cycleSpeed: 30
				)
				(= cycles (= cycles (= cycles (= cycles 30))))
			)
			(4
				(= local9 0)
				(cond 
					((proc819_5 136) (EcoNarrator posn: -1 30 init: 3 0 0 32 self))
					((proc819_5 139) (EcoNarrator posn: -1 30 init: 3 0 0 24 self))
					(else (= local9 1) (= ticks (= ticks (= ticks (= ticks 1)))))
				)
			)
			(5
				(if local0
					(self setScript: octFromFrontToHide self)
				else
					(= ticks (= ticks (= ticks (= ticks 30))))
				)
			)
			(6
				(proc0_1)
				(= ticks (= ticks (= ticks (= ticks 30))))
			)
			(7
				(if local9
					((ScriptID 2 0) init: 2 0 0 26 1 self)
				else
					(EcoNarrator posn: -1 30 init: 3 0 0 27 self)
				)
			)
			(8
				(gEgo setCycle: CT 5 1)
				(octopus
					setCycle: 0
					view: 482
					loop: 4
					cel: 1
					x: 148
					y: 99
					cycleSpeed: 24
					setCycle: CT 6 1 self
				)
			)
			(9
				(if local9
					(EcoNarrator posn: -1 30 init: 3 0 0 55 self)
				else
					(++ state)
					(= ticks (= ticks (= ticks (= ticks 1))))
				)
			)
			(10
				((ScriptID 2 0) init: 2 0 0 27 1 self)
			)
			(11
				(gEgo cel: 6)
				(octopus cel: 7)
				(= cycles (= cycles (= cycles (= cycles 5))))
			)
			(12
				(if (proc819_5 136)
					(= ticks (= ticks (= ticks (= ticks 1))))
				else
					(EcoNarrator posn: -1 130 init: 3 0 0 25 self)
				)
			)
			(13
				(gSoundEffects number: 483 loop: 1 play:)
				(gEgo setCycle: End)
				(octopus setCycle: End self)
			)
			(14
				(octopus
					setLoop: 5
					x: 106
					y: 96
					xStep: 8
					cycleSpeed: 16
					setCycle: Fwd
					setMotion: PolyPath -50 (octopus y?) self
				)
				(gEgo posn: 193 94)
				(proc819_6 7 802)
			)
			(15
				(octopus stopUpd: hide:)
				(= ticks (= ticks (= ticks (= ticks 120))))
			)
			(16
				(if (proc819_5 136)
					(EcoNarrator posn: -1 30 init: 3 0 0 33 self)
				else
					((ScriptID 2 1) init: 1 0 0 27 1 self)
				)
			)
			(17
				(if (proc819_5 136)
					(= ticks (= ticks (= ticks (= ticks 1))))
				else
					((ScriptID 2 0) init: 2 0 0 20 1 self)
				)
			)
			(18
				(if (not (proc819_5 73))
					(gDelph setMotion: MoveTo 215 64 self)
				else
					(= ticks (= ticks (= ticks (= ticks 1))))
				)
			)
			(19
				(= local5 0)
				(= local2 0)
				(= local1 0)
				(= local0 0)
				(proc819_3 139)
				(proc819_3 101)
				(proc819_3 136)
				(= local4 1)
				(if (not (proc819_5 73))
					(gDelph setMotion: PFollow gEgo 90)
				)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance egoPlaceJar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(if (not (proc819_5 139))
					(EcoNarrator init: 3 0 0 54 self)
				else
					(= ticks (= ticks (= ticks (= ticks 1))))
				)
			)
			(1
				(gEgo setMotion: PolyPath 220 126 self)
			)
			(2
				(gEgo setMotion: PolyPath 208 121 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 481
					loop: 2
					cel: 0
					posn: 152 129
					cycleSpeed: 16
					setCycle: CT 2 1 self
				)
			)
			(4
				(Jar init: show:)
				(gEgo posn: 208 121)
				(proc819_6)
				(gEgo setMotion: PolyPath 200 116 self)
			)
			(5
				(gEgo setHeading: 270)
				(gEgo put: 32 480)
				(= local7 1)
				(if (proc819_5 139)
					((ScriptID 2 0) init: 2 0 0 3 1 self)
				else
					((ScriptID 2 0) init: 2 0 0 25 1 self)
				)
				(proc819_6)
			)
			(6 (proc0_2) (self dispose:))
		)
	)
)

(instance egoHides of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 200 110 self)
			)
			(1
				(gEgo setMotion: PolyPath 167 140 self)
			)
			(2
				(gEgo setCycle: 0)
				(= ticks (= ticks (= ticks (= ticks 10))))
			)
			(3
				(gEgo
					view: 481
					setLoop: 3
					x: 130
					y: 172
					setPri: 15
					cycleSpeed: 18
					cel: 0
					setCycle: End self
				)
				(proc0_4 5 315)
			)
			(4
				(gEgo setCycle: CT 9 -1)
				(= ticks (= ticks (= ticks (= ticks 120))))
			)
			(5
				(gEgo setCycle: CT 11 1)
				(= ticks (= ticks (= ticks (= ticks 120))))
			)
			(6
				(proc0_2)
				(if (or (== local4 1) (== global233 1))
					(frond0 setScript: egoUnhides self)
				else
					(EcoNarrator posn: -1 50 init: 3 0 0 46)
					(if (== local7 1)
						(octopus setScript: octOpensJar self)
					else
						(frond0 setScript: egoUnhides self)
					)
				)
			)
			(7 (self dispose:))
		)
	)
)

(instance egoUnhides of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(gEgo setCycle: CT 9 -1 self)
			)
			(1
				(gEgo hide: view: 802 loop: 0 posn: 100 140)
				(= ticks (= ticks (= ticks (= ticks 10))))
			)
			(2
				(proc819_6 0 802)
				(= ticks (= ticks (= ticks (= ticks 10))))
			)
			(3
				(if (not (proc819_5 73))
					(gDelph setMotion: MoveTo 215 66 self)
				else
					(= ticks (= ticks (= ticks (= ticks 2))))
				)
			)
			(4
				(gEgo show: setMotion: PolyPath 155 125)
				(self dispose:)
			)
		)
	)
)

(instance octFromAboveToFront of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(octopus
					view: 482
					setLoop: 7
					posn: 151 78
					cel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(octopus posn: 153 94 cel: 1 setCycle: End self)
			)
			(2
				(= local1 0)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance octFromFrontToHide of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(octopus
					view: 482
					setLoop: 9
					setCycle: 0
					cel: 4
					posn: 154 110
				)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(1
				(octopus cel: 3)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(2
				(octopus posn: 152 99 cel: 2)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(3
				(octopus cel: 1)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(4
				(octopus posn: 145 99 cel: 0)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(5
				(= local0 0)
				(= local2 1)
				(self dispose:)
			)
		)
	)
)

(instance octFromHideToFront of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(octopus
					view: 482
					setLoop: 9
					setCycle: 0
					cel: 1
					posn: 152 99
				)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(1
				(octopus cel: 2)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(2
				(octopus posn: 154 110 cel: 3)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(3
				(octopus cel: 4)
				(= cycles (= cycles (= cycles (= cycles 14))))
			)
			(4
				(= local0 1)
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance octOpensJar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(if (not (proc819_5 73))
					(gDelph setMotion: PolyPath 260 50 self)
				else
					(self cue:)
				)
			)
			(1
				(if (not (proc819_5 73))
					(gDelph setMotion: PolyPath 240 60)
				)
				(cond 
					((== local2 1) (self setScript: octFromHideToFront self))
					((== local1 1) (self setScript: octFromAboveToFront self))
					((== local0 1) (= ticks (= ticks (= ticks (= ticks 1)))))
				)
			)
			(2
				(proc0_1)
				(if (not (proc819_5 139))
					(proc819_3 139)
					((ScriptID 2 0) init: 2 0 0 24 1 self)
				else
					(self cue:)
				)
			)
			(3
				(EcoNarrator posn: -1 20 init: 3 0 0 41)
				(octopus
					posn: 154 104
					setLoop: 1
					setCycle: End self
					cycleSpeed: 8
				)
				(Jar hide:)
				(= ticks (= ticks (= ticks (= ticks 60))))
			)
			(4
				(octopus setCycle: End self)
				(if (not (proc819_5 73))
					(gDelph setMotion: PolyPath 250 50)
				)
			)
			(5
				(octopus setLoop: 2 setCycle: End self)
			)
			(6
				(octopus setCycle: End self)
				(= register (= register (= register (= register 3))))
			)
			(7
				(octopus loop: 3 cycleSpeed: 18 setCycle: CT 12 1 self)
			)
			(8
				(gDelph setHeading: 225 self)
			)
			(9
				(EcoNarrator posn: -1 20 init: 3 0 0 42 self)
			)
			(10
				(octopus setCycle: CT 9 -1 self)
			)
			(11
				(gSoundEffects number: 481 loop: 1 play:)
				(octopus setCycle: CT 12 1 self)
			)
			(12
				(if (-- register)
					(= state (= state (= state (= state (- state 3)))))
					(= cycles (= cycles (= cycles (= cycles 1))))
				else
					(octopus setCycle: End self)
				)
			)
			(13
				(= global233 1)
				((ScriptID 2 0) init: 2 0 0 8 1 self)
				(proc0_4 5 311)
			)
			(14
				(Jar setCel: 1 x: (- (Jar x?) 11) show:)
				(self setScript: octFromFrontToHide self)
			)
			(15
				(frond0 setScript: egoUnhides self)
			)
			(16
				(gEgo setMotion: PolyPath 210 103)
				(if (not (proc819_5 73))
					(gDelph setMotion: PFollow gEgo 90)
				)
				(proc0_2)
				(self dispose:)
			)
		)
	)
)

(instance egoPicksUpJar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(proc0_1)
				(gEgo setMotion: PolyPath 220 126 self)
			)
			(1
				(gEgo setMotion: PolyPath 202 121 self)
			)
			(2
				(gEgo get: 32)
				(= local7 0)
				(Jar hide: dispose:)
				(proc819_6)
				(= ticks (= ticks (= ticks (= ticks 30))))
				(proc0_4 2 314)
			)
			(3
				(cond 
					((!= global233 1) (= ticks (= ticks (= ticks (= ticks 1)))))
					((or (proc819_5 101) (not (proc819_5 139))) (EcoNarrator posn: -1 20 init: 3 0 0 80 self))
					(else (EcoNarrator posn: -1 20 init: 3 0 0 48 self))
				)
			)
			(4 (proc0_2) (self dispose:))
		)
	)
)

(instance timedHelpBubbles of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(= ticks (= ticks (= ticks (= ticks 4200))))
				(self setScript: bubbleComment)
			)
			(1
				(= ticks (= ticks (= ticks (= ticks 2400))))
			)
			(2
				(helpBubbles
					posn: 300 5
					show:
					cel: 0
					setCycle: CT 8 1
					setMotion: MoveTo 280 20
				)
				(= ticks (= ticks (= ticks (= ticks 240))))
			)
			(3
				(helpBubbles hide:)
				(= ticks (= ticks (= ticks (= ticks 480))))
			)
			(4
				(helpBubbles
					posn: 300 5
					show:
					cel: 0
					setCycle: CT 8 1
					setMotion: MoveTo 280 20
				)
				(= ticks (= ticks (= ticks (= ticks 240))))
			)
			(5
				(helpBubbles hide:)
				(= ticks (= ticks (= ticks (= ticks 60))))
			)
			(6
				(if (not (proc819_5 67))
					(= state (= state (= state (= state 0))))
				)
				(self cue:)
			)
			(7 (self dispose:))
		)
	)
)

(instance bubbleComment of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(= ticks (= ticks (= ticks (= ticks 13200))))
			)
			(1
				(if (not (proc819_5 73))
					((ScriptID 2 0) init: 2 0 0 19 1 self)
				else
					(= cycles (= cycles (= cycles (= cycles 1))))
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance followingFish of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state (= state (= state newState))))
			(0
				(= cycles (= cycles (= cycles (= cycles 4))))
			)
			(1
				(switch gSouth
					(440
						(if (== global124 gNumber)
							(EcoNarrator posn: -1 130 init: 3 0 0 51 self)
						else
							(= cycles (= cycles (= cycles (= cycles 1))))
						)
					)
					(500
						(if (== global124 gNumber)
							(= global124 440)
							(EcoNarrator posn: -1 130 init: 3 0 0 52 self)
						else
							(= cycles (= cycles (= cycles (= cycles 1))))
						)
					)
				)
			)
			(2
				(if (and (== gSouth 440) (== global124 gNumber))
					(= global124 500)
					(gEgo setMotion: PolyPath 50 84 self)
				else
					(= cycles (= cycles (= cycles (= cycles 1))))
				)
			)
			(3 (self dispose:))
		)
	)
)
