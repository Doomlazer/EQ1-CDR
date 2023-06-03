;;; Sierra Script 1.0 - (do not remove this comment)
(script# 961)
(include sci.sh)
(use Cycle)

(public
	StopWalk 0
)

(class StopWalk of Fwd
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		vWalking 0
		vStopped 0
	)
	
	(method (init theClient theVStopped)
		(if argc
			(= vWalking ((= client theClient) view?))
			(if (>= argc 2) (= vStopped theVStopped))
		)
		(super init: client)
		(self doit:)
	)
	
	(method (doit &tmp clientLoop temp1)
		(if (client isStopped:)
			(cond 
				(
					(and
						(== vStopped -1)
						(!= (client loop?) (- (NumLoops client) 1))
					)
					(= clientLoop (client loop?))
					(super doit:)
					(client
						loop: (- (NumLoops client) 1)
						setCel: clientLoop
					)
				)
				(
				(and (!= vStopped -1) (== (client view?) vWalking)) (client view: vStopped) (super doit:))
			)
		else
			(switch vStopped
				((client view?)
					(client view: vWalking)
				)
				(-1
					(client setLoop: -1 setCel: -1)
					(if (== (client loop?) (- (NumLoops client) 1))
						(client loop: (client cel?) cel: 0)
					)
				)
			)
			(super doit:)
		)
	)
	
	(method (dispose)
		(if (== (client view?) vStopped)
			(client view: vWalking)
		)
		(super dispose:)
	)
)
