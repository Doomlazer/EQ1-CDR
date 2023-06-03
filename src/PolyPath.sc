;;; Sierra Script 1.0 - (do not remove this comment)
(script# 945)
(include sci.sh)
(use Main)
(use Cycle)
(use Obj)


(class PolyPath of Motion
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
		value 2
		points 0
		finalX 0
		finalY 0
		obstacles 0
	)
	
	(method (init theClient theFinalX theFinalY theCaller param5 theObstacles &tmp [temp0 30])
		(if argc
			(= client theClient)
			(if (> argc 1)
				(cond 
					((>= argc 6) (= obstacles theObstacles))
					((not (IsObject obstacles)) (= obstacles (global2 obstacles?)))
				)
				(if points (Memory memFREE points))
				(= points
					(AvoidPath
						(theClient x?)
						(theClient y?)
						(= finalX theFinalX)
						(= finalY theFinalY)
						(if obstacles (obstacles elements?) else 0)
						(if obstacles (obstacles size?) else 0)
						(if (>= argc 5) param5 else 1)
					)
				)
				(if (> argc 3) (= caller theCaller))
			)
			(self setTarget:)
		)
		(super init:)
	)
	
	(method (dispose)
		(if points (Memory memFREE points))
		(= points 0)
		(super dispose:)
	)
	
	(method (moveDone)
		(if (== (proc999_6 points value) 30583)
			(super moveDone:)
		else
			(self setTarget: init:)
		)
	)
	
	(method (setTarget &tmp temp0 theX theY temp3 [temp4 30])
		(if (!= (proc999_6 points value) 30583)
			(= x (proc999_6 points value))
			(= y (proc999_6 points (++ value)))
			(++ value)
			(if
			(and (IsObject global95) (= temp3 (global95 size?)))
				(= temp0
					(AvoidPath
						(client x?)
						(client y?)
						x
						y
						(global95 elements?)
						temp3
						0
					)
				)
				(= theX (proc999_6 temp0 2))
				(= theY (proc999_6 temp0 3))
				(if (or (!= x theX) (!= y theY))
					(= x theX)
					(= y theY)
					(Memory memPOKE (+ points value 2) 30583)
				)
				(Memory memFREE temp0)
			)
		)
	)
)
