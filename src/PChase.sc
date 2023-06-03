;;; Sierra Script 1.0 - (do not remove this comment)
(script# 930)
(include sci.sh)
(use Main)
(use PolyPath)
(use Obj)


(class PChase of PolyPath
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
		who 0
		distance 0
		targetX 0
		targetY 0
	)
	
	(method (init theClient theWho theDistance theCaller theObstacles &tmp [temp0 20])
		(if argc
			(cond 
				((>= argc 5) (= obstacles theObstacles))
				((not (IsObject obstacles)) (= obstacles (global2 obstacles?)))
			)
			(if (>= argc 1)
				(= client theClient)
				(if (>= argc 2)
					(= who theWho)
					(= targetX (who x?))
					(= targetY (who y?))
					(if (>= argc 3)
						(= distance theDistance)
						(if (>= argc 4) (= caller theCaller))
					)
				)
			)
			(super init: client targetX targetY caller 1 obstacles)
		else
			(super init:)
		)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(
				(>
					(GetDistance targetX targetY (who x?) (who y?))
					distance
				)
				(if points (Memory memFREE points))
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(
			(<= (= temp0 (client distanceTo: who)) distance) (self moveDone:))
			(else (super doit:))
		)
	)
	
	(method (moveDone &tmp temp0 [temp1 20])
		(cond 
			(
			(<= (= temp0 (client distanceTo: who)) distance) (super moveDone:))
			((== (proc999_6 points value) 30583)
				(if points (Memory memFREE points))
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(else (self setTarget: init:))
		)
	)
)
