;;; Sierra Script 1.0 - (do not remove this comment)
(script# 521)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use Cycle)
(use Obj)

(public
	shark 0
)

(procedure (localproc_0022 param1 param2 param3 param4)
	(EcoNarrator
		modeless: 1
		posn: -1 10
		init: param2 0 2 (- param3 72) param4 param1
	)
)

(instance shark of EcoActor
	(properties
		x 120
		y 170
		z 20
		view 565
		priority 13
		signal $0010
		cycleSpeed 12
	)
	
	(method (init)
		(= global250 1)
		(super init: &rest)
		(teeth init: hide:)
		(self setScript: sharkSwims)
		(global2 setScript: sharkScares)
	)
)

(instance teeth of EcoProp
	(properties
		x 149
		y 174
		z 21
		view 565
		loop 4
		priority 13
		signal $0010
		cycleSpeed 12
	)
	
	(method (doit)
		(= x (= x (+ (shark x?) 29)))
		(= y (= y (+ (shark y?) 4)))
		(= priority (= priority (shark priority?)))
		(super doit: &rest)
	)
)

(instance sharkScares of HandsOffScript
	(properties)
	
	(method (changeState newState &tmp temp0 [temp1 50])
		(switch (= state (= state newState))
			(0 (= ticks (= ticks 150)))
			(1
				(= temp0 (if (proc819_5 138) 86 else 82))
				(proc819_3 138)
				(localproc_0022 4 (+ global250 1) temp0 self)
			)
			(2 (= ticks (= ticks 90)))
			(3
				(localproc_0022 4 (+ global250 1) 83 self)
			)
			(4
				(localproc_0022 4 (+ global250 1) 84 self)
			)
			(5
				(localproc_0022 4 (+ global250 1) 85 self)
			)
			(6
				(if (== gNumber 520)
					(gEgo setMotion: PolyPath 260 108 self)
				else
					(gEgo setMotion: PolyPath 93 79 self)
				)
			)
			(7
				(global2 newRoom: (if (== gNumber 520) 540 else 580))
			)
		)
	)
)

(instance sharkSwims of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(shark
					setLoop: 0
					cel: 0
					setMotion: MoveTo 400 (shark y?)
					setCycle: End self
				)
			)
			(1
				(shark setMotion: MoveTo 400 (shark y?) setCycle: End)
				(teeth cel: 0 show: setCycle: End self)
			)
			(2
				(teeth hide:)
				(shark setLoop: 2 cel: 0 setMotion: 0 setCycle: End self)
			)
			(3
				(shark posn: (- (shark x?) 15) (- (shark y?) 27))
				(shark
					setLoop: 1
					cel: 0
					setMotion: MoveTo 80 (shark y?) self
					setCycle: Fwd
				)
			)
			(4
				(shark setLoop: 3 cel: 0 setMotion: 0 setCycle: End self)
			)
			(5
				(shark posn: (- (shark x?) 10) (+ (shark y?) 30))
				(self changeState: 0)
			)
		)
	)
)
