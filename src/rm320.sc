;;; Sierra Script 1.0 - (do not remove this comment)
(script# 320)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm320 0
)

(procedure (localproc_0048)
	(= global112 0)
	(global2
		addObstacle:
			((Polygon new:)
				type: 3
				init: 131 189 105 76 0 76 0 189
				yourself:
			)
	)
	(easternCliffs addToPic:)
)

(procedure (localproc_0085)
	(= global112 4)
	(global2
		addObstacle:
			((Polygon new:)
				type: 3
				init: 319 189 319 75 162 75 199 189
				yourself:
			)
	)
	(westernCliffs addToPic:)
)

(instance rm320 of EcoRoom
	(properties
		picture 320
		style $8009
		horizon 122
		north 321
		south 381
		lookStr 1
	)
	
	(method (init)
		(= global250 1)
		(proc819_6)
		(gEgo init: ignoreHorizon: 1 put: 17)
		((gEgo cycler?) caller: sepEgoDel)
		(if (proc999_5 gSouth 380 400 381)
			(gEgo x: 160)
			(= global112 2)
		)
		(super init: &rest)
		(switch global112
			(0
				(gEgo x: 80)
				(localproc_0048)
			)
			(4
				(gEgo x: 240)
				(localproc_0085)
			)
		)
		(sky init:)
		((gIconBar at: 0) loop: 0)
		((gIconBar at: 0) maskLoop: 0)
		(gLongSong number: 923 loop: -1 play:)
	)
	
	(method (doit)
		(if (not script)
			(switch (gEgo edgeHit?)
				(2 (self setScript: toEast))
				(4 (self setScript: toWest))
			)
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 7))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (proc999_5 newRoomNumber 380 400 381)
			(gLongSong fade:)
			((gIconBar at: 0) loop: 9)
			((gIconBar at: 0) loop: 9)
		)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (notify)
		(if (== gSouth south)
			((ScriptID 2 0) init: 2 0 0 10 1)
		)
	)
)

(instance toWest of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo -38 (gEgo y?) self)
			)
			(1
				(gEgo x: 280 edgeHit: 0 setMotion: 0)
				(global2 drawPic: 320)
				(if (== global112 2)
					(localproc_0085)
				else
					(= global112 2)
					(easternCliffs dispose:)
					(if (global2 obstacles?)
						((global2 obstacles?) eachElementDo: #dispose release:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance toEast of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 358 (gEgo y?) self)
			)
			(1
				(gEgo x: 36 edgeHit: 0 setMotion: 0)
				(global2 drawPic: 320)
				(if (== global112 2)
					(localproc_0048)
				else
					(= global112 2)
					(easternCliffs dispose:)
					(if (global2 obstacles?)
						((global2 obstacles?) eachElementDo: #dispose release:)
					)
				)
				(self dispose:)
			)
		)
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
		)
	)
)

(instance easternCliffs of EcoView
	(properties
		x 149
		y 307 ;51
		view 326
		signal $5001
		lookStr 3
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westernCliffs of EcoView
	(properties
		x 4
		y 276 ;20
		view 325
		signal $5001
		lookStr 3
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sky of EcoFeature
	(properties
		lookStr 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (EcoNarrator init: 1 0 0 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (< (param1 y?) 70))
	)
)
