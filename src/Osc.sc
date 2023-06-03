;;; Sierra Script 1.0 - (do not remove this comment)
(script# 939)
(include sci.sh)
(use Cycle)


(class Osc of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		howManyCycles -1
	)
	
	(method (init param1 theHowManyCycles theCaller)
		(if (>= argc 2)
			(= howManyCycles theHowManyCycles)
			(if (>= argc 3) (= caller theCaller))
		)
		(super init: param1)
	)
	
	(method (doit &tmp oscNextCel)
		(if
			(or
				(> (= oscNextCel (self nextCel:)) (client lastCel:))
				(< oscNextCel 0)
			)
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: oscNextCel)
		)
	)
	
	(method (cycleDone)
		(if howManyCycles
			(client cel: (self nextCel:))
			(if (> howManyCycles 0) (-- howManyCycles))
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)
