;;; Sierra Script 1.0 - (do not remove this comment)
(script# 818)
(include sci.sh)
(use Main)
(use PolyPath)
(use Obj)


(class PRunAway of PolyPath
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
		triedOpposite 0
		oldDistance 999
		targetX 0
		targetY 0
		moveDistance 0
	)
	
	(method (init theClient theWho theDistance theMoveDistance theObstacles)
		(cond 
			((>= argc 5) (= obstacles theObstacles))
			((not (IsObject obstacles)) (= obstacles (global2 obstacles?)))
		)
		(if (>= argc 1)
			(= client theClient)
			(if (>= argc 2)
				(= who theWho)
				(if (>= argc 3)
					(= distance theDistance)
					(if (>= argc 4) (= moveDistance theMoveDistance))
				)
			)
		)
		(= completed 0)
		(super
			init: client (client x?) (client y?) 0 1 obstacles
		)
	)
	
	(method (doit &tmp temp0 clientHeading)
		(= temp0 (client distanceTo: who))
		(cond 
			((and (client isBlocked:) (not completed))
				(if (not triedOpposite)
					(= triedOpposite 1)
					(= clientHeading
						(-
							(GetAngle (who x?) (who x?) (client x?) (client y?))
							45
						)
					)
				else
					(= clientHeading (client heading?))
				)
				(= clientHeading
					(mod (* (+ (/ clientHeading 45) (Random 1 3)) 45) 360)
				)
				(client
					signal: (& (client signal?) $fbff)
					heading: clientHeading
				)
				(switch clientHeading
					(0
						(= targetY (- (client y?) moveDistance))
						(= targetX (client x?))
					)
					(45
						(= targetY (- (client y?) moveDistance))
						(= targetX (+ (client x?) moveDistance))
					)
					(90
						(= targetY (client y?))
						(= targetX (+ (client x?) moveDistance))
					)
					(135
						(= targetY (+ (client y?) moveDistance))
						(= targetX (+ (client x?) moveDistance))
					)
					(180
						(= targetY (client x?))
						(= targetX (+ (client y?) moveDistance))
					)
					(225
						(= targetY (+ (client y?) moveDistance))
						(= targetX (- (client x?) moveDistance))
					)
					(270
						(= targetY (client y?))
						(= targetX (- (client x?) moveDistance))
					)
					(315
						(= targetY (- (client y?) moveDistance))
						(= targetX (- (client x?) moveDistance))
					)
				)
				(if points (Memory memFREE points))
				(= points 0)
				(= value 2)
				(super init: client targetX targetY 0 1 obstacles)
			)
			((> temp0 distance) (= triedOpposite 0) (super doit:))
			((and (<= temp0 distance) completed)
				(= completed 0)
				(client signal: (| (client signal?) $0400))
				(= triedOpposite 0)
				(self doit:)
			)
			(else (super doit:))
		)
	)
	
	(method (moveDone &tmp temp0)
		(cond 
			(
			(> (= temp0 (client distanceTo: who)) moveDistance))
			((<= temp0 distance)
				(client signal: (| (client signal?) $0400))
				(= completed 0)
			)
			((== (proc999_6 points value) 30583)
				(if points (Memory memFREE points))
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(else (self init:))
		)
	)
	
	(method (motionCue)
		(if
		(and completed (<= (client distanceTo: who) distance))
			(client signal: (| (client signal?) $0400))
			(= completed 0)
		)
	)
)
