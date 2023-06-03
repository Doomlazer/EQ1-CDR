;;; Sierra Script 1.0 - (do not remove this comment)
(script# 342)
(include sci.sh)
(use Main)
(use EcoRoom)
(use n819)
(use PFollow)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm342 0
)

(instance rm342 of EcoRoom
	(properties
		picture 340
		style $8009
		horizon 20
		north 343
		picAngle 89
		walkOffTop 1
	)
	
	(method (init)
		(self setRegions: 51)
		(proc819_6)
		(gEgo ignoreHorizon: 1 init:)
		(proc819_7)
		(gDelph z: 0 ignoreHorizon: 1 init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 188 0 1 3 1 3 187
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 318 187 318 2 319 0 319 185
					yourself:
				)
		)
		(super init: &rest)
		(switch gSouth
			(343 (self setScript: fromNet))
			(480 (self setScript: fromReef))
			(500 (self setScript: fromReef))
			(else 
				(gEgo x: 230 y: 100)
				(gDelph x: 120 y: 100)
			)
		)
	)
)

(instance fromReef of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(if (== gSouth 480) (gEgo x: 70) else (gEgo x: 300))
				(gEgo y: 230 setMotion: MoveTo 140 60 self)
				(gDelph
					posn: (gEgo x?) (+ (gEgo y?) 60)
					setMotion: PFollow gEgo 90
				)
			)
			(1
				(gEgo setMotion: MoveTo 140 -40 self)
			)
			(2
				(proc0_2)
				(global2 newRoom: 343)
				(self dispose:)
			)
		)
	)
)

(instance fromNet of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				(if (< (gEgo x?) 180)
					(rm342 south: 480)
					(gEgo x: 90 setMotion: MoveTo 60 240 self)
				else
					(rm342 south: 500)
					(gEgo x: 210 setMotion: MoveTo 290 240 self)
				)
				(gDelph
					posn: (gEgo x?) (- (gEgo y?) 80)
					setMotion: PFollow gEgo 50
				)
			)
			(1
				(proc0_2)
				(if (< (gEgo x?) 180)
					(global2 newRoom: 480)
				else
					(global2 newRoom: 500)
				)
				(self dispose:)
			)
		)
	)
)
